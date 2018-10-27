package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class PrincipalController {
	
	@FXML
	TabPane tabPane;
	@FXML
	RadioButton ckOrientado;
	@FXML
	RadioButton ckValorado;

	@FXML
	TextField txtVertice;
	@FXML
	TextField txtOrigem;
	@FXML
	TextField txtDestino;
	@FXML
	TextField txtValor;
	
	@FXML
	public void abreAdjacenciaIncidencia() {
		abreTab("Matriz/Lista", "ListaMatriz.fxml");
	}
	
	@FXML
	public void abreDistancia() {
		abreTab("Matriz", "Distancia.fxml");
	}
	
	@FXML
	public void abreCaminhoMinimo() {
		abreTab("Caminho Minímo", "CaminhoMinimo.fxml");
	}
	
	@FXML
	public void abre() {

	}
	
	private void abreTab(String titulo, String path) {
		try {
			Tab tab = tabAberta(titulo);
			if (tab == null) {
				tab = new Tab(titulo);
				tab.setClosable(true);
				tabPane.getTabs().add(tab);
				tab.setContent((Node) FXMLLoader.load(getClass().getResource(path)));
			}
			selecionaTab(tab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Tab tabAberta(String titulo) {
		for (Tab tab : tabPane.getTabs()) {
			if (!(tab.getText() == null) && tab.getText().equals(titulo)) {
				return tab;
			}
		}
		return null;
	}

	private void selecionaTab(Tab tab) {
		tabPane.getSelectionModel().select(tab);
	}
	
}
