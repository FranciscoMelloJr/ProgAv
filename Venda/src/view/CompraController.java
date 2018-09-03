package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Produto;

public class CompraController {
	
	@FXML TextField txtNome;
	@FXML TextField txtValor;
	@FXML TextField txtQnt;
	@FXML TextField txtTotal;
	
	@FXML TableView<Produto> tbl;
	@FXML TableColumn<Produto, String> colNome;
	@FXML TableColumn<Produto, Number> colValor;
	@FXML TableColumn<Produto, Number> colQnt;
	@FXML TableColumn<Produto, Number> colSub;
	
	private ArrayList<Produto> produtos = new ArrayList<Produto>();

	@FXML
	public void initialize() {
		InicializaTabela();
		
	}
	
	@FXML
	public void incluir() {
		Produto p = new Produto();
		p.setNome(txtNome.getText());
		p.setValor(Double.parseDouble(txtValor.getText()));
		p.setQnt(Integer.parseInt(txtQnt.getText()));
		p.setSub(p.getValor()*p.getQnt());
		produtos.add(p);
		tbl.setItems(FXCollections.observableArrayList(produtos));
		
	}
	
	@FXML
	public void selecionaProduto() {

		Produto p = tbl.getSelectionModel().getSelectedItem();
		
		txtNome.setText(p.getNome());
		txtValor.setText(String.format("%g", p.getValor()));
		txtQnt.setText(String.format("%d", p.getQnt()));
		
	}
	private void InicializaTabela() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colValor.setCellValueFactory(cellData -> cellData.getValue().valorProperty());
		colQnt.setCellValueFactory(cellData -> cellData.getValue().qntProperty());
		colSub.setCellValueFactory(cellData -> cellData.getValue().subProperty());

	}
	
	@FXML
	public void limpaTela() {
		txtNome.setText("");
		txtValor.setText("");
		txtQnt.setText("");
		
	}
	
	@FXML public void finalizarCompra() {
		double aux = 0;
		for (Produto p : produtos) 
			aux = p.getSub() + aux;
		txtTotal.setText("R$"+aux);
		
	}
}