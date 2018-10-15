package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Funcionario;

public class PrincipalController {

	@FXML
	ComboBox<String> txtFunc;
	@FXML
	TextField txtTempo;
	@FXML
	TextField txtQuantidade;

	@FXML
	TableView<Funcionario> tbl;
	@FXML
	TableColumn<Funcionario, String> colFuncionario;
	@FXML
	TableColumn<Funcionario, Number> colQuantidade;
	@FXML
	TableColumn<Funcionario, Number> colTempo;
	@FXML
	ProgressBar bar1;
	@FXML
	ProgressBar bar2;
	@FXML
	ProgressBar bar3;

	private ArrayList<Funcionario> funcionarios = new ArrayList<>();

	@FXML
	public void initialize() {
		inicializaComboUF();
		inicializaTbl();
	}

	@FXML
	public void iniciaComThread() {
		for (Funcionario f : funcionarios) {
			if (f.getNome().equals("João") && (f.getQuantidade() != 0)) {
				Funcionario aux = new Funcionario(f.getQuantidade(), f.getTempo(), bar1);
				new Thread(aux).start();
			}
			if (f.getNome().equals("José") && (f.getQuantidade() != 0)) {
				Funcionario aux = new Funcionario(f.getQuantidade(), f.getTempo(), bar2);
				new Thread(aux).start();
			}
			if (f.getNome().equals("Paulo") && (f.getQuantidade() != 0)) {
				Funcionario aux = new Funcionario(f.getQuantidade(), f.getTempo(), bar3);
				new Thread(aux).start();
			}

		}

	}

	@FXML
	public void incluir() {

		Funcionario f = new Funcionario();
		f.setNome(txtFunc.getSelectionModel().getSelectedItem());
		f.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
		f.setTempo(Integer.parseInt(txtTempo.getText()));
		funcionarios.add(f);
		tbl.setItems(FXCollections.observableArrayList(funcionarios));
		txtFunc.getItems().remove(txtFunc.getSelectionModel().getSelectedItem());
		limpaTela();
	}

	@FXML
	public void limpaTela() {
		txtQuantidade.setText("");
		txtTempo.setText("");

	}

	public void inicializaComboUF() {
		txtFunc.getItems().add("João");
		txtFunc.getItems().add("José");
		txtFunc.getItems().add("Paulo");
		txtFunc.getSelectionModel().select(0);

	}

	private void inicializaTbl() {
		colFuncionario.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colQuantidade.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());
		colTempo.setCellValueFactory(cellData -> cellData.getValue().tempoProperty());

	}

}
