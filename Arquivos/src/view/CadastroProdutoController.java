package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Produto;

public class CadastroProdutoController {

	@FXML
	TextField txtCod;
	@FXML
	TextField txtNome;
	@FXML
	TextField txtValor;
	@FXML
	TextField txtQnt;

	@FXML
	TableView<Produto> tbl;
	@FXML
	TableColumn<Produto, Number> colCod;
	@FXML
	TableColumn<Produto, String> colNome;
	@FXML
	TableColumn<Produto, Number> colValor;
	@FXML
	TableColumn<Produto, Number> colQuantidade;

	private ArrayList<Produto> produtos = new ArrayList<>();

	@FXML
	public void initialize() {
		inicializaTableView();
		lerArquivo();
	}

	@FXML
	public void cadastrar() {
		gravar();
		lerArquivo();
		limparTela();
	}

	public void lerArquivo() {

		produtos.clear();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("produto.txt"))) {

			String linha = "";

			while ((linha = bufferedReader.readLine()) != null) {

				String cod = linha.substring(0, 3);
				String nome = linha.substring(3, 13);

				String valorAntesVirgula = linha.substring(13, 16);
				String valorDepoisVirgula = linha.substring(16, 18);
				String valor = valorAntesVirgula + "." + valorDepoisVirgula;

				String quantidade = linha.substring(18, 21);

				Produto produto = new Produto();
				produto.setCod(Integer.parseInt(cod));
				produto.setNome(nome);
				produto.setValor(Double.parseDouble(valor));
				produto.setQuantidade(Integer.parseInt(quantidade));
				produtos.add(produto);
			}

			tbl.setItems(FXCollections.observableArrayList(produtos));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void gravar() {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("produto.txt", true))) {

			Produto produto = new Produto();
			produto.setCod(Integer.parseInt(txtCod.getText()));
			produto.setNome(txtNome.getText());
			produto.setValor(Double.parseDouble(txtValor.getText()));
			produto.setQuantidade(Integer.parseInt(txtQnt.getText()));

			String cod = String.format("%03d", produto.getCod()).substring(0, 3);
			String nome = String.format("%-10.10s", produto.getNome());
			String valor = String.format("%06.2f", produto.getValor()).substring(0, 6).replace(",", "");
			String quatidade = String.format("%03d", produto.getQuantidade());

			bufferedWriter.append(cod + nome + valor + quatidade + "\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inicializaTableView() {

		colCod.setCellValueFactory(cellData -> cellData.getValue().codProperty());
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colValor.setCellValueFactory(cellData -> cellData.getValue().valorProperty());
		colQuantidade.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());

	}

	public void limparTela() {

		txtCod.setText("");
		txtNome.setText("");
		txtQnt.setText("");
		txtValor.setText("");
	}

}
