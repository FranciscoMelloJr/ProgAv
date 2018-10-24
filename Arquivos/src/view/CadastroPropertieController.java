package view;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class CadastroPropertieController {

	@FXML
	TextField txtLargura;
	@FXML
	TextField txtAltura;
	@FXML
	TextField txtRazaoSocial;
	@FXML
	TextField txtLogotipo;

	@FXML
	ColorPicker txtCor;

	@FXML
	public void abreArquivo() {
		FileChooser fc = new FileChooser();
		File selecionado = fc.showOpenDialog(null);
		if (selecionado != null) {
			txtLogotipo.setText(selecionado.getAbsolutePath());
		}
	}

	@FXML
	public void gravar() {
		File f = new File(txtLogotipo.getText());
		if (f.isFile()) {
			Properties properties = new Properties();
			properties.setProperty("Largura", txtLargura.getText());
			properties.setProperty("Altura", txtAltura.getText());
			properties.setProperty("Logo", txtLogotipo.getText());
			properties.setProperty("Cor", "#" + Integer.toHexString(txtCor.getValue().hashCode()));
			properties.setProperty("RazaoSocial", txtRazaoSocial.getText());

			try (FileWriter fw = new FileWriter("propertie.txt")) {
				properties.store(fw, "Arquivo de preferências");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
