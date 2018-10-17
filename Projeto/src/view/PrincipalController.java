package view;

import java.io.File;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import model.Dadosfile;

public class PrincipalController {

	@FXML
	TextField txtPath;
	@FXML
	TableView<Dadosfile> tbl;
	@FXML
	TableColumn<Dadosfile, String> colNome;
	@FXML
	TableColumn<Dadosfile, String> colTamanho;

	private ArrayList<Dadosfile> lista = new ArrayList<Dadosfile>();
	
	@FXML
	public void initialize() {
		inicializaTabela();
	}

	@FXML
	public void apagaLinhaSelecionada() {
		Dadosfile df = tbl.getSelectionModel().getSelectedItem();
		if (df != null) {
			File f = new File(df.getPath());
			f.delete();
			lista.remove(df);
			tbl.setItems(FXCollections.observableArrayList(lista));
		}

	}

	@FXML
	public void listar() {
		if (!txtPath.getText().equals("")) {
			File diretorio = new File(txtPath.getText());
			if (diretorio.isDirectory()) {
				File[] v = diretorio.listFiles();
				for (File f : v) {
					Dadosfile dados = new Dadosfile();
					dados.setNome(f.getName());
					dados.setTamanho(f.length() + "");
					dados.setPath(f.getAbsolutePath());
					lista.add(dados);
				}
				tbl.setItems(FXCollections.observableArrayList(lista));
			}
		}

	}

	@FXML
	private void apagaTodos() {
		for (Dadosfile df : tbl.getItems()) {
			File f = new File(df.getPath());
			f.delete();
		}
		lista.clear();
		tbl.setItems(FXCollections.observableArrayList(lista));
	}

	@FXML
	public void abreDiretorio() {
		DirectoryChooser dc = new DirectoryChooser();
		File selecionado = dc.showDialog(null);
		if (selecionado != null) {
			txtPath.setText(selecionado.getAbsolutePath());
		}
	}

	private void inicializaTabela() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colTamanho.setCellValueFactory(cellData -> cellData.getValue().tamanhoProperty());
	}
}
