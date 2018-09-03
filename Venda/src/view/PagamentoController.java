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
	
	@FXML ComboBox<String> txtCidade;
	
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	@FXML
	public void inicializaComboCidade() {
		txtCidade.getItems().add("Tubarão");
		txtCidade.getItems().add("Laguna");
		txtCidade.getItems().add("Imbituba");
		txtCidade.getItems().add("Garopaba");
		txtCidade.getItems().add("Florianópolis");
		txtCidade.getItems().add("Criciúma");
		txtCidade.getSelectionModel().select(1);
		
	}
	
	
	@FXML
	public void registrar() {
		
			Cliente c = new Cliente();
			c.setNome(txtCliente.getText());
			c.setCart(ckCart.isSelected());
			c.setBol(ckBol.isSelected());
			c.setDep(ckDep.isSelected());
			c.setCidade(txtCidade.getSelectionModel().getSelectedItem());
			
			clientes.add(c);
			
	}
	
	
	//colMat.setCellValueFactory(cellData -> cellData.getValue().matProperty().get()?new SimpleStringProperty("X"):new SimpleStringProperty(""));		
	//colVesp.setCellValueFactory(cellData -> cellData.getValue().vesProperty().get()?new SimpleStringProperty("X"):new SimpleStringProperty(""));
	//colNot.setCellValueFactory(cellData -> cellData.getValue().notProperty().get()?new SimpleStringProperty("X"):new SimpleStringProperty(""));

}
