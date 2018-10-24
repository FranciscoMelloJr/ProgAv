package view;

import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;

public class CadastroPropertieController {
	
	@FXML TextField txtLargura;
	@FXML TextField txtAltura;
	@FXML TextField txtSocial;
	@FXML TextField txtLogotipo;
	
	@FXML ColorPicker txtColor;
	
	@FXML
	public void initialize {
		lerArquivo();
		pane.setMinWidth(largura);
		pane.setMinHeigth(largura);
		
		try {
			
			img.setImage(new Image(new FileInputStream(logo)));
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pane.setStyle("-fx-background-color: #"+cor.substring(4));
	}
	
	private File selecionaInagem() {
		
		FileChooser.getChooser.Extensionfilter("imagens")
		
	}
	
	
	
}
