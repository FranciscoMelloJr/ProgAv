package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Corredor;

public class PrincipalController {

	@FXML
	TextField txtNome;
	@FXML
	TextField txtPeito;
	@FXML
	TextField txtDistancia;
	@FXML
	DatePicker txtDataNascimento;

	@FXML
	TableView<Corredor> tbl;
	@FXML
	TableColumn<Corredor, String> colNome;
	@FXML
	TableColumn<Corredor, Number> colPeito;
	@FXML
	TableColumn<Corredor, Number> colDistancia;
	@FXML
	TableColumn<Corredor, String> colFaixa;

	private ArrayList<Corredor> corredores = new ArrayList<>();

	@FXML
	public void initialize() {
		inicializaTbl();
	}

	private void inicializaTbl() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colPeito.setCellValueFactory(cellData -> cellData.getValue().peitoProperty());
		colDistancia.setCellValueFactory(cellData -> cellData.getValue().distanciaProperty());
		colFaixa.setCellValueFactory(cellData -> cellData.getValue().faixaProperty());

	}

	private int calculaIdadeJava8(LocalDate dtNasc) {
		LocalDate hoje = LocalDate.now();
		long idade = ChronoUnit.YEARS.between(dtNasc, hoje);
		return (int) idade;
	}

	@FXML
	public void incluir() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Corredor c = new Corredor();
		c.setNome(txtNome.getText());
		c.setNasc(dtf.format(txtDataNascimento.getValue()));
		c.setIdade(calculaIdadeJava8(txtDataNascimento.getValue()));
		corredores.add(c);
		tbl.setItems(FXCollections.observableArrayList(corredores));
	}

}
