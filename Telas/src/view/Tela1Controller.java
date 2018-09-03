package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Tela1Controller {
	
	@FXML TextField txtN1;
	@FXML TextField txtN2;
	@FXML TextField txtResult;
	
	@FXML
	public void somar() {
		double number1 = Double.parseDouble(txtN1.getText());
		double number2 = Double.parseDouble(txtN2.getText());
		double result = number1 + number2;
		txtResult.setText(String.format("soma: %s", result));
	}
	
}
