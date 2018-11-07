package view;

import java.util.Objects;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class PrincipalController {
	@FXML
	TabPane tabPane;
	
	@FXML
	public void abreTelaCadastro() {
		abreTab("Cadastro", "Cadastro.fxml");
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
	
	private void selecionaTab(Tab tab) {
		tabPane.getSelectionModel().select(tab);
	}
	
	private Tab tabAberta(String titulo) {
		for (Tab tab : tabPane.getTabs()) {
			if (Objects.nonNull(tab.getText()) && tab.getText().equals(titulo)) {
				return tab;
			}
		}
		return null;
	}
}
