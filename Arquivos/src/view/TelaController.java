package view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TelaController {

	@FXML
	TabPane tabPane;

	@FXML
	public void abrePrincipal() {
		abreTab("Arquivo", "Principal.fxml");
	}

	@FXML
	public void abreAluno() {
		abreTab("Cadastro Aluno", "Aluno.fxml");
	}

	@FXML
	public void abreTransporte() {
		abreTab("Transporte Aluno", "Transporte.fxml");
	}

	@FXML
	public void abreCadastro() {
		abreTab("Cadastro Propertie", "CadastroPropertie.fxml");
	}

	@FXML
	public void abrePropertie() {
		abreTab("Propertie", "Propertie.fxml");
	}

	@FXML
	public void abreCadastroProduto() {
		abreTab("Cadastro Produto", "CadastroProduto.fxml");
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
