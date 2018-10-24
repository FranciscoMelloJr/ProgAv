package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
		Properties propertie = new Properties();
		try (FileReader fr = new FileReader("propertie.txt")) {
			propertie.load(fr);
			razaoSocial = propertie.getProperty("RazaoSocial");
			cor = propertie.getProperty("Cor");
			logo = propertie.getProperty("Logo");
			largura = Integer.parseInt(propertie.getProperty("Largura"));
			altura = Integer.parseInt(propertie.getProperty("Altura"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private File selecionaInagem() {
		
	//	FileChooser.getChooser.Extensionfilter("imagens")
		
	}

//}
