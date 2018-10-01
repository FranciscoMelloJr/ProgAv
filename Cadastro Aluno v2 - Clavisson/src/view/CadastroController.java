package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Aluno;

public class CadastroController {
	
	@FXML TextField txtNome;
	@FXML TextField txtFiltro;
	
	@FXML RadioButton rdMasc;
	@FXML RadioButton rdFem;
	
	@FXML DatePicker txtDataNascimento;
	
	@FXML ComboBox<String> txtUf;
	
	@FXML CheckBox ckMatutino;
	@FXML CheckBox ckVespertino;
	@FXML CheckBox ckNoturno;
	
	@FXML TableView<Aluno> tbl;
	@FXML TableColumn<Aluno, String> colNome;
	@FXML TableColumn<Aluno, Number> colIdade;
	@FXML TableColumn<Aluno, String> colSexo;
	@FXML TableColumn<Aluno, String> colMat;
	@FXML TableColumn<Aluno, String> colVesp;
	@FXML TableColumn<Aluno, String> colNot;
	
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	
	@FXML
	public void initialize() {
		inicializaComboUF();
		inicializaTbl();
	}
	
	@FXML
	public void selecionaAluno() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Aluno a = tbl.getSelectionModel().getSelectedItem();
		
		txtNome.setText(a.getNome());
		if(a.getSexo().equals("M")) {
			rdMasc.setSelected(true);
			rdFem.setSelected(false);
		}
		if(a.getSexo().equals("F")) {
			rdMasc.setSelected(false);
			rdFem.setSelected(true);
		}
		txtUf.getSelectionModel().select(a.getUf());
		txtDataNascimento.setValue(LocalDate.parse(a.getNasc(), dtf));
		ckMatutino.setSelected(a.isMat());
		ckVespertino.setSelected(a.isVes());
		ckNoturno.setSelected(a.isNot());
	}
	
	@FXML
	public void incluir() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Aluno a = new Aluno();
		a.setNome(txtNome.getText());
		a.setSexo(rdMasc.isSelected()?"M":"F");
		a.setNasc(dtf.format(txtDataNascimento.getValue()));
		a.setUf(txtUf.getSelectionModel().getSelectedItem());
		a.setMat(ckMatutino.isSelected());
		a.setVes(ckVespertino.isSelected());
		a.setNot(ckNoturno.isSelected());
		a.setIdade(calculaIdadeJava8(txtDataNascimento.getValue()));
		alunos.add(a);
		tbl.setItems(FXCollections.observableArrayList(alunos));
	}
	
	@FXML
	public void filtrar() {
		if(txtFiltro.getText().equals("")) {
			tbl.setItems(FXCollections.observableArrayList(alunos));
		}else {
			ArrayList<Aluno> aux = new ArrayList<Aluno>();
			for (Aluno a : alunos) {
				if(a.getNome().startsWith(txtFiltro.getText())) {
					aux.add(a);
				}
			}
			tbl.setItems(FXCollections.observableArrayList(aux));
		}
	}
	
	
	
	private void inicializaComboUF() {
		txtUf.getItems().add("MT");
		txtUf.getItems().add("SC");
		txtUf.getItems().add("PR");
		txtUf.getItems().add("RJ");
		txtUf.getItems().add("RS");
		txtUf.getSelectionModel().select(1);
	}
	
	private void inicializaTbl() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colIdade.setCellValueFactory(cellData -> cellData.getValue().idadeProperty());
		colSexo.setCellValueFactory(cellData -> cellData.getValue().sexoProperty());
		
		colMat.setCellValueFactory(cellData -> 
		cellData.getValue().matProperty().get()
		?new SimpleStringProperty("X")
		:new SimpleStringProperty(""));
		
		colVesp.setCellValueFactory(cellData -> 
		cellData.getValue().vesProperty().get()
		?new SimpleStringProperty("X")
		:new SimpleStringProperty(""));
		
		colNot.setCellValueFactory(cellData -> 
		cellData.getValue().notProperty().get()
		?new SimpleStringProperty("X")
		:new SimpleStringProperty(""));
	}
	
	private int calculaIdadeJava8(LocalDate dtNasc) {
		LocalDate hoje = LocalDate.now();
		long idade = ChronoUnit.YEARS.between(dtNasc, hoje);
		return (int) idade;
	}
	
	
	
}
