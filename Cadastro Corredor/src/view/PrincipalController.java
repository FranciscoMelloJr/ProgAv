package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import model.Corredor;

public class PrincipalController {

	@FXML
	TextField txtNome;
	@FXML
	TextField txtPeito;
	@FXML
	ComboBox<String> txtDistancia;
	@FXML
	DatePicker txtDataNascimento;

	@FXML
	TableView<Corredor> tbl;
	@FXML
	TableColumn<Corredor, String> colNome;
	@FXML
	TableColumn<Corredor, Number> colPeito;
	@FXML
	TableColumn<Corredor, String> colDistancia;
	@FXML
	TableColumn<Corredor, String> colFaixa;

	private ArrayList<Corredor> corredores = new ArrayList<>();

	@FXML
	public void initialize() {
		inicializaTbl();
		inicializaComboUF();
	}

	private void inicializaTbl() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colPeito.setCellValueFactory(cellData -> cellData.getValue().peitoProperty());
		colDistancia.setCellValueFactory(cellData -> cellData.getValue().distanciaProperty());
		colFaixa.setCellValueFactory(cellData -> cellData.getValue().faixaProperty());

	}

	public void inicializaComboUF() {
		txtDistancia.getItems().add("5Km");
		txtDistancia.getItems().add("10Km");
		txtDistancia.getItems().add("15Km");
		txtDistancia.getItems().add("30Km");
		txtDistancia.getItems().add("42Km");

	}

	private int calculaIdadeJava8(LocalDate dtNasc) {
		LocalDate hoje = LocalDate.now();
		long idade = ChronoUnit.YEARS.between(dtNasc, hoje);
		return (int) idade;
	}

	@FXML
	public void incluir() {

		try {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			Corredor c = new Corredor();
			c.setNome(txtNome.getText());
			if (temNumero(txtNome.getText()))
				throw new Exception("\nInsira um nome válido");
			c.setNasc(dtf.format(txtDataNascimento.getValue()));
			c.setIdade(calculaIdadeJava8(txtDataNascimento.getValue()));
			c.setPeito(Integer.parseInt(txtPeito.getText()));
			if (c.getPeito() < 0)
				throw new Exception("\nInsira um número de peito positivo");
			c.setDistancia(txtDistancia.getSelectionModel().getSelectedItem());
			if (c.getIdade() < 20)
				throw new Exception("\nIdade minímia de 20 anos!");
			if ((c.getIdade() >= 20) && (c.getIdade() < 30))
				c.setFaixa("A");
			else if ((c.getIdade() >= 30) && (c.getIdade() < 40))
				c.setFaixa("B");
			else if ((c.getIdade() >= 40) && (c.getIdade() < 50))
				c.setFaixa("C");
			else if ((c.getIdade() >= 50) && (c.getIdade() < 60)) {
				c.setFaixa("D");
			} else {
				c.setFaixa("E");
			}
			corredores.add(c);
			tbl.setItems(FXCollections.observableArrayList(corredores));
			limpaTela();
		} catch (NumberFormatException e) {
			mostraMensagem("Insira um número válido\n" + e.getMessage(), AlertType.WARNING);
		} catch (Exception e) {
			mostraMensagem("Erro\n" + e.getMessage(), AlertType.WARNING);
		}
	}

	public void mostraMensagem(String msg, AlertType tipo) {
		Alert a = new Alert(tipo);
		a.setHeaderText(null);
		a.setContentText(msg);
		a.show();

	}

	@FXML
	public void limpaTela() {
		txtNome.setText("");
		txtPeito.setText("");
		txtDistancia.setValue(null);
		txtDataNascimento.setValue(null);

	}

	public boolean temNumero(final String nome) {
		String numeros = "0123456789";
		for (char a : nome.toCharArray())
			for (char b : numeros.toCharArray())
				if (a == b)
					return true;
		return false;
	}

}