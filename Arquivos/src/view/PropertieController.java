package view;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class PropertieController {
	
	String razaoSocial;
	String cor;
	String logo;
	int largura;
	int altura;
	
	@FXML
	AnchorPane pane;
	@FXML
	Label label;
	@FXML
	ImageView img;
	
	
	@FXML
	public void initialize() {
		lerArquivo();
		pane.setMinWidth(largura);
		pane.setMinHeight(altura);
		label.setText(razaoSocial);
		try {
			img.setImage(new Image(new FileInputStream(logo)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pane.setStyle("-fx-background-color: " + cor);
	}
	
	private void lerArquivo() {
		Properties prop = new Properties();
		try (FileReader fr = new FileReader("preferencias.properties")) {
			prop.load(fr);
			razaoSocial = prop.getProperty("RazaoSocial");
			cor = prop.getProperty("Cor");
			logo = prop.getProperty("Logo");
			largura = Integer.parseInt(prop.getProperty("Largura"));
			altura = Integer.parseInt(prop.getProperty("Altura"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private File selecionaInagem() {
		
	//	FileChooser.getChooser.Extensionfilter("imagens")
		
	}

//}
