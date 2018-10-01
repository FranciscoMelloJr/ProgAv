package view;

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
	@FXML TableColumn<Aluno, String> colTurnos;
	
	@FXML
	public void initialize() {
		txtUf.getItems().add("MT");
		txtUf.getItems().add("SC");
		txtUf.getItems().add("PR");
		txtUf.getItems().add("RJ");
		txtUf.getItems().add("RS");
		txtUf.getSelectionModel().select(1);
	}
	
}
