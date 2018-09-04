package view;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Cliente;

public class PagamentoController {
	
	@FXML RadioButton ckCart;
	@FXML RadioButton ckBol;
	@FXML RadioButton ckDep;
	@FXML TextField txtCliente;
	@FXML TextField txtClient;
	@FXML TextField txtCity;
	@FXML TextField txtPagamento;
	
	@FXML ComboBox<String> txtCidade;
	
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	@FXML
	public void initialize() {
		txtCidade.getItems().add("Tubarão");
		txtCidade.getItems().add("Laguna");
		txtCidade.getItems().add("Imbituba");
		txtCidade.getItems().add("Garopaba");
		txtCidade.getItems().add("Florianópolis");
		txtCidade.getItems().add("Criciúma");
		txtCidade.getSelectionModel().select(0);
		
	}
	
	@FXML
	public void registrar() {
		
			Cliente c = new Cliente();
			c.setNome(txtCliente.getText());
			if(ckCart.isSelected())
					txtPagamento.setText("Cartão");
			if(ckBol.isSelected())
				txtPagamento.setText("Boleto");
			if(ckDep.isSelected())
				txtPagamento.setText("Depósito");
			txtClient.setText(c.getNome());
			c.setCidade(txtCidade.getSelectionModel().getSelectedItem());
			txtCity.setText(c.getCidade());	
			clientes.add(c);
			
			}
}
