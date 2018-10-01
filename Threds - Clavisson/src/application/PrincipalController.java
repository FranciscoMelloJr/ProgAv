package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class PrincipalController {
	
	@FXML TabPane tabPane;
	
	@FXML
	public void abreTela1() {
		abreTab("Thread", "Tela1.fxml");
	}
	@FXML
	public void abreTela2() {
		abreTab("Imagem", "Tela2.fxml");
	}
	@FXML
	public void abreTela3() {
		abreTab("Calendário", "Tela3.fxml");
	}
	@FXML
	public void abreTela4() {
		abreTab("Cor", "Tela4.fxml");
	}
	
	
	private Tab tabAberta(String titulo) {
		for (Tab tb : tabPane.getTabs()) {
			if(tb.getText().equals(titulo)) 
				return tb;
		}
		return null;
	}
	
	private void selecionaTab(Tab tab) {
		tabPane.getSelectionModel().select(tab);
	}
	
	private void abreTab(String titulo, String path) {
		try{
			Tab tab = tabAberta(titulo);
			if (tab==null) {
				tab = new Tab(titulo);
				tab.setClosable(true);
				tabPane.getTabs().add(tab);
				tab.setContent((Node) FXMLLoader.
						load(getClass().getResource(path)));
			}
			selecionaTab(tab);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
