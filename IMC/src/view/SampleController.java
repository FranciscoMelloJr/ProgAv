package view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class SampleController {

	@FXML
	TextField txtNome;
	@FXML
	TextField txtPeso;
	@FXML
	TextField txtAltura;
	@FXML
	TextField txtResultado;
	@FXML
	RadioButton rdMasc;
	@FXML
	RadioButton rdFem;

	@FXML
	public void calculaImc() {

		double peso = Double.parseDouble(txtPeso.getText());
		double altura = Double.parseDouble(txtAltura.getText());
		double imc =  peso / (altura * altura);
		BigDecimal bd = new BigDecimal(imc).setScale(2, RoundingMode.HALF_EVEN);
		if (rdMasc.isSelected()) {
			txtResultado.setText("Senhor, seu IMC é: " + bd);
		} else
			txtResultado.setText("Senhora, seu IMC é: " + bd);
	}

	@FXML
	public void limpaTela() {
		txtNome.setText("");
		txtPeso.setText("");
		txtAltura.setText("");
		txtResultado.setText("");
		rdMasc.setSelected(false);
		rdFem.setSelected(false);
	}
}
