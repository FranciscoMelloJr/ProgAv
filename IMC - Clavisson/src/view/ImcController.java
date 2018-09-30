package view;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ImcController {
	
	@FXML TextField txtNome;
	@FXML TextField txtPeso;
	@FXML TextField txtAltura;
	@FXML TextField txtResultado;
	@FXML RadioButton rdMasc;
	@FXML RadioButton rdFem;
	
	@FXML
	public void calculaImc() {
		
		//if(rdMasc.isSelected())
		//txtNome.setText("");
		double peso = Double.parseDouble(txtPeso.getText());
		double altura = Double.parseDouble(txtAltura.getText());
		double imc = peso / (altura*altura);
		txtResultado.setText(imc+"");
	}
	
	
	
}
