package calculadora;

import java.awt.TextField;

import javafx.fxml.FXML;

public class TelaPrinContr {
	
	@FXML private TextField txtN1;
	@FXML private TextField txtN2;
	@FXML private TextField txtResult;

	@FXML
	public void somar(){
		int n1 = Integer.parseInt(txtN1.getText());
		int n2 = Integer.parseInt(txtN2.getText());
		int result = n1+n2;
		txtResult.setText(result+"");
	}
	@FXML
	public void multiplicar(){
		int n1 = Integer.parseInt(txtN1.getText());
		int n2 = Integer.parseInt(txtN2.getText());
		int result = n1*n2;
		txtResult.setText(result+"");
	}
	@FXML
	public void dividir(){
		int n1 = Integer.parseInt(txtN1.getText());
		int n2 = Integer.parseInt(txtN2.getText());
		int result = n1/n2;
		txtResult.setText(result+"");
	}
	@FXML
	public void subtrair(){
		int n1 = Integer.parseInt(txtN1.getText());
		int n2 = Integer.parseInt(txtN2.getText());
		int result = n1-n2;
		txtResult.setText(result+"");
	}
}
