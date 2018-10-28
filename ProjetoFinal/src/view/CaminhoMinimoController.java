package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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

	ArrayList<Vertice> verticeLista = new ArrayList<Vertice>();
	ArrayList<Aresta> arestaLista = new ArrayList<Aresta>();
	boolean valorado, orientado;
	Fila fila = new Fila();
	Vertice destiny;

	@FXML
	public void initialize() {
		inicializaTbl();
		lerArquivoProperties();
		leVertice();
		leAresta();

	}

	private void leAresta() {
		arestaLista.clear();
		try (BufferedReader br = new BufferedReader(new FileReader("aresta.txt"))) {
			String linha = "";
			while ((linha = br.readLine()) != null) {
				String origem = linha.substring(0, 5);
				String destino = linha.substring(5, 10);
				int valor = Integer.parseInt(linha.substring(10, 13));
				Aresta a = new Aresta();
				a.setOrigem(origem);
				a.setDestino(destino);
				a.setValor(valor);
				arestaLista.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void leVertice() {
		verticeLista.clear();
		try (BufferedReader br = new BufferedReader(new FileReader("vertice.txt"))) {
			String linha = "";
			while ((linha = br.readLine()) != null) {
				Vertice v = new Vertice();
				String nome = linha.substring(0, 5);
				v.setNome(nome);
				verticeLista.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void lerArquivoProperties() {
		Properties propertie = new Properties();
		try (FileReader fr = new FileReader("conf.properties")) {
			propertie.load(fr);
			orientado = Boolean.valueOf(propertie.getProperty("orientado"));
			valorado = Boolean.valueOf(propertie.getProperty("valorado"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void dijkstra() {

		while (fila.tamanho() != 0) {
			Vertice atual = fila.remove();
			for (int i = 0; i < atual.getAdj().size(); i++) {
				if (!atual.getAdj().get(i).isPerm()) {
					for (Aresta aresta : arestaLista) {
						if (orientado) {
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

	@FXML //
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

		if (ckDestiny.isSelected())
			for (Vertice vertice : verticeLista) {
				if (vertice.getNome().equals(txtDestiny.getText())) {
					destiny = vertice;
				}
			}
		txtDestiny.setText("");
		dijkstra();

	}

	private void inicializaTbl() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colDistancia.setCellValueFactory(cellData -> cellData.getValue().distanciaProperty());
		colPath.setCellValueFactory(cellData -> cellData.getValue().pathProperty());

	}

}
