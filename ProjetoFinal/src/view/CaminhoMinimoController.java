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

	public static final String BLACK = "Preto";
	public static final String GRAY = "Cinza";
	public static final String WHITE = "Branco";
	public static final String ARESTA_TXT = "aresta.txt";
	public static final String CONF_PROPERTIES = "conf.properties";
	public static final String VERTICE_TXT = "vertice.txt";

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
	@FXML
	TableColumn<Vertice, Number> colProfundidade;

	ArrayList<Vertice> verticeLista = new ArrayList<Vertice>();
	ArrayList<Aresta> arestaLista = new ArrayList<Aresta>();
	boolean valorado, orientado;
	Fila fila = new Fila();
	Vertice source, destiny;
	int time = 0;

	public void escolherAlgoritmo() {

		if ((!valorado) && (!orientado))
			buscaLargura();
		if ((!valorado) && (orientado))
			buscaProfundidade();
		if (valorado)
			dijkstra();

	}

	@FXML
	public void initialize() {
		inicializaTbl();
		lerArquivoProperties();
		leVertice();
		leAresta();

	}

	private void inicializaTbl() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colDistancia.setCellValueFactory(cellData -> cellData.getValue().distanciaProperty());
		colProfundidade.setCellValueFactory(cellData -> cellData.getValue().profundidadeProperty());
		colPath.setCellValueFactory(cellData -> cellData.getValue().pathProperty());

	}

	private void lerArquivoProperties() {
		Properties propertie = new Properties();
		try (FileReader fr = new FileReader(CONF_PROPERTIES)) {
			propertie.load(fr);
			orientado = Boolean.valueOf(propertie.getProperty("orientado"));
			valorado = Boolean.valueOf(propertie.getProperty("valorado"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void leVertice() {
		verticeLista.clear();
		try (BufferedReader br = new BufferedReader(new FileReader(VERTICE_TXT))) {
			String linha = "";
			while ((linha = br.readLine()) != null) {
				Vertice v = new Vertice();
				String nome = linha.substring(0, 5).trim();
				v.setNome(nome);
				verticeLista.add(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void leAresta() {
		arestaLista.clear();
		try (BufferedReader br = new BufferedReader(new FileReader(ARESTA_TXT))) {
			String linha = "";
			while ((linha = br.readLine()) != null) {
				String origem = linha.substring(0, 5).trim();
				String destino = linha.substring(5, 10).trim();
				int valor = Integer.parseInt(linha.substring(10, 13).trim());
				Aresta aresta = new Aresta();
				aresta.setOrigem(origem);
				aresta.setDestino(destino);
				aresta.setValor(valor);
				adicionaAdjacente(aresta);
				arestaLista.add(aresta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adicionaAdjacente(Aresta aresta) {

		for (Vertice vertice : verticeLista) {
			if (vertice.getNome().equals(aresta.getOrigem())) {
				for (Vertice adjacente : verticeLista) {
					if (adjacente.getNome().equals(aresta.getDestino())) {
						vertice.getAdj().add(adjacente);
						if (!orientado)
							adjacente.getAdj().add(vertice);
					}
				}
			}
		}
	}

	@FXML
	public void buscaLargura() {

		while (fila.tamanho() != 0) {
			Vertice atual = fila.remove();
			for (int i = 0; i < atual.getAdj().size(); i++) {
				if (atual.getAdj().get(i).getCor().equals(WHITE)) {
					atual.getAdj().get(i).setCor(GRAY);
					atual.getAdj().get(i).setDistancia(atual.getDistancia() + 1);
					atual.getAdj().get(i).setPath(atual.getNome());
					fila.insere(atual.getAdj().get(i));
				}
			}
			atual.setCor(BLACK);
			if ((ckDestiny.isSelected()) && (destiny.getCor().equals(GRAY))) {
				break;
			}
		}
		tbl.setItems(FXCollections.observableArrayList(verticeLista));
	}

	@FXML
	public void buscaProfundidade() {

		colDistancia.setText("Visitado");
		colProfundidade.setText("Busca Completa");
		source.setCor(WHITE);
		dfsVisit(source);
		for (Vertice vertice : verticeLista) {
			if (vertice.getCor().equals(WHITE))
				dfsVisit(vertice);
		}
		tbl.setItems(FXCollections.observableArrayList(verticeLista));
	}

	public void dfsVisit(Vertice vertice) {

		if ((ckDestiny.isSelected()) && (destiny.getCor().equals(GRAY))) {
			return;
		}
		vertice.setCor(GRAY);
		time++;
		vertice.setDistancia(time);
		for (int i = 0; i < vertice.getAdj().size(); i++) {
			if (vertice.getAdj().get(i).getCor().equals(WHITE)) {
				vertice.getAdj().get(i).setPath(vertice.getNome());
				dfsVisit(vertice.getAdj().get(i));
			}
		}
		vertice.setCor(BLACK);
		time++;
		vertice.setProfundidade(time);
	}

	@FXML
	public void dijkstra() {
		colDistancia.setText("Distância");
		while (fila.tamanho() != 0) {
			Vertice atual = fila.remove();
			for (int i = 0; i < atual.getAdj().size(); i++) {
				if (atual.getAdj().get(i).getCor().equals(WHITE)) {
					for (Aresta aresta : arestaLista) {
						if (orientado) {
							if ((atual.getNome().equals(aresta.getOrigem()))
									&& (atual.getAdj().get(i).getNome().equals(aresta.getDestino()))) {
								alteraDistanciaDijkstra(atual, aresta, i);
							}
						} else {
							if ((atual.getNome().equals(aresta.getOrigem())
									|| atual.getNome().equals(aresta.getDestino()))
									&& (atual.getAdj().get(i).getNome().equals(aresta.getDestino())
											|| atual.getAdj().get(i).getNome().equals(aresta.getOrigem()))) {
								alteraDistanciaDijkstra(atual, aresta, i);
							}
						}
					}
				}
			}
			insereAdjacentesDijkstra(atual);
			atual.setCor(GRAY);
			if ((ckDestiny.isSelected()) && (destiny.getCor().equals(GRAY))) {
				break;
			}
		}
		tbl.setItems(FXCollections.observableArrayList(verticeLista));
	}

	public void alteraDistanciaDijkstra(Vertice atual, Aresta aresta, int i) {

		for (Vertice vertice : verticeLista) {
			if (vertice.getNome().equals(atual.getAdj().get(i).getNome())) {
				if (atual.getDistancia() + aresta.getValor() < vertice.getDistancia()) {
					vertice.setDistancia((atual.getDistancia() + aresta.getValor()));
					vertice.setPath(atual.getNome());
				}
			}
		}
	}

	public void insereAdjacentesDijkstra(Vertice vertice) {

		for (int i = 0; i < vertice.getAdj().size(); i++) {
			if (!vertice.getAdj().get(i).getCor().equals(GRAY)) {
				if (!(fila.verificaIgual((vertice.getAdj().get(i).getNome())))) {
					fila.inserePrioridade(vertice.getAdj().get(i));
				}
			}
		}
	}

	@FXML
	public void sourceDestinyEnd() {

		for (Vertice vertice : verticeLista) {
			if (vertice.getNome().equalsIgnoreCase(txtSource.getText())) {
				source = vertice;
			}
		}
		source.setDistancia(0);
		source.setCor(GRAY);
		fila.insere(source);
		txtSource.setText("");

		if (ckDestiny.isSelected())
			for (Vertice vertice : verticeLista) {
				if (vertice.getNome().equalsIgnoreCase(txtDestiny.getText())) {
					destiny = vertice;
				}
			}
		txtDestiny.setText("");
		escolherAlgoritmo();

	}

	@FXML
	public void destinySN() {
		if (ckDestiny.isSelected()) {
			txtDestiny.setDisable(false);
		} else {
			txtDestiny.setDisable(true);
		}
	}

}
