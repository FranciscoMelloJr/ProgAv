package view;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import model.Competicao;

public class PrincipalController {

	@FXML
	TextField txtNome;
	@FXML
	TextField txtDistancia;
	@FXML
	DatePicker txtData;
	@FXML
	TextField txtColocacao;
	@FXML
	TextField txtMelhor;

	@FXML
	TableView<Competicao> tbl;
	@FXML
	TableColumn<Competicao, String> colNome;
	@FXML
	TableColumn<Competicao, String> colData;
	@FXML
	TableColumn<Competicao, Number> colDistancia;
	@FXML
	TableColumn<Competicao, Number> colColocacao;

	private ArrayList<Competicao> competicoes = new ArrayList<>();

	@FXML
	public void initialize() {
		inicializaTbl();
	}

	private void inicializaTbl() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colData.setCellValueFactory(cellData -> cellData.getValue().dataProperty());
		colDistancia.setCellValueFactory(cellData -> cellData.getValue().distanciaProperty());
		colColocacao.setCellValueFactory(cellData -> cellData.getValue().colocaçãoProperty());

	}

	@FXML
	public void incluir() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Competicao c = new Competicao();
		c.setNome(txtNome.getText());
		c.setData(dtf.format(txtData.getValue()));
		c.setColocação(Integer.parseInt(txtColocacao.getText()));
		c.setDistancia(Integer.parseInt(txtDistancia.getText()));
		competicoes.add(c);
		tbl.setItems(FXCollections.observableArrayList(competicoes));
		limpaTela();

	}

	@FXML
	public void remover() {

		Competicao c = tbl.getSelectionModel().getSelectedItem();
		for (Competicao x : competicoes)
			if (c.toString().equals(x.toString()))
				tbl.getItems().removeAll(tbl.getSelectionModel().getSelectedItems());
		System.out.println(competicoes.toString());
	}

	@FXML
	public void limpaTela() {
		txtNome.setText("");
		txtColocacao.setText("");
		txtDistancia.setText("");
		txtData.setValue(null);

	}

}
