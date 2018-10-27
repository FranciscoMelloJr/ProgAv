package view;

import java.io.FileReader;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Aresta;
import model.Fila;
import model.Vertice;

public class CaminhoMinimoController {

	@FXML
	TextField txtSource;
	@FXML
	TextField txtDestiny;
	
	@FXML
	RadioButton ckDestiny;

	@FXML
	TableView<Vertice> tbl;
	@FXML
	TableColumn<Vertice, String> colNome;
	@FXML
	TableColumn<Vertice, Number> colDistancia;
	@FXML
	TableColumn<Vertice, String> colPath;
	
	
	Fila fila = new Fila();
	Vertice destiny;

	@FXML
	public void initialize() {
		inicializaTbl();
	}

	private void lerArquivoProperties() {
		Properties propertie = new Properties();
		try (FileReader fr = new FileReader("conf.properties")) {
			propertie.load(fr);
			txtInstituicaoEnsino.setText(propertie.getProperty("nome"));
			txtMediaA.setText(propertie.getProperty("mediaA"));
			txtMediaR.setText(propertie.getProperty("mediaR"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void finalizar() {

		while (fila.tamanho() != 0) {
			Vertice atual = fila.remove();
			for (int i = 0; i < atual.getAdj().size(); i++) {
				if (!atual.getAdj().get(i).isPerm()) {
					for (Aresta aresta : arestaLista) {
						if (ckOrientado.isSelected()) {
							if ((atual.getNome().equals(aresta.getOrigem()))
									&& (atual.getAdj().get(i).getNome().equals(aresta.getDestino()))) {
								alteraDist(atual, aresta, i);
							}
						} else {
							if ((atual.getNome().equals(aresta.getOrigem())
									|| atual.getNome().equals(aresta.getDestino()))
									&& (atual.getAdj().get(i).getNome().equals(aresta.getDestino())
											|| atual.getAdj().get(i).getNome().equals(aresta.getOrigem()))) {
								alteraDist(atual, aresta, i);
							}
						}
					}
				}
			}
			insereADJ(atual);
			atual.setPerm(true);
			if ((ckDestiny.isSelected()) && (destiny.isPerm())) {
				break;
			}
		}
		tbl.setItems(FXCollections.observableArrayList(verticeLista));
	}

	public void alteraDist(Vertice atual, Aresta aresta, int i) {

		for (Vertice vertice : verticeLista) {
			if (vertice.getNome().equals(atual.getAdj().get(i).getNome())) {
				if (atual.getDistancia() + aresta.getValor() < vertice.getDistancia()) {
					vertice.setDistancia((atual.getDistancia() + aresta.getValor()));
					vertice.setPath(atual.getNome());
				}
			}
		}
	}

	public void insereADJ(Vertice vertice) {

		for (int i = 0; i < vertice.getAdj().size(); i++) {
			if (!vertice.getAdj().get(i).isPerm()) {
				if (!(fila.verificaIgual((vertice.getAdj().get(i).getNome())))) {
					fila.insere(vertice.getAdj().get(i));
				}
			}
		}
	}

	@FXML
	public void adicionaDestiny() {

		for (Vertice vertice : verticeLista) {
			if (vertice.getNome().equals(txtDestiny.getText())) {
				destiny = vertice;
			}
		}
		txtDestiny.setText("");

	}

	@FXML
	public void destinySN() {
		if (ckDestiny.isSelected()) {
			txtDestiny.setDisable(false);
		} else {
			txtDestiny.setDisable(true);
		}
	}

	@FXML
	public void adicionaSource() {

		Vertice source = null;
		for (Vertice vertice : verticeLista) {
			if (vertice.getNome().equals(txtSource.getText())) {
				source = vertice;
			}
		}
		source.setDistancia(0);
		source.setPerm(true);
		fila.insere(source);
		txtSource.setText("");

	}


	private void inicializaTbl() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colDistancia.setCellValueFactory(cellData -> cellData.getValue().distanciaProperty());
		colPath.setCellValueFactory(cellData -> cellData.getValue().pathProperty());

	}
	
}
