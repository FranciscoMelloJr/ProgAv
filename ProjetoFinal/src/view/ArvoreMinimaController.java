package view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Aresta;
import model.Fila;
import model.FilaAresta;
import model.Vertice;

public class ArvoreMinimaController {

	public static final String ARESTA_TXT = "aresta.txt";
	public static final String CONF_PROPERTIES = "conf.properties";
	public static final String VERTICE_TXT = "vertice.txt";

	@FXML
	TextField txtCusto;
	@FXML
	TextField txtSource;

	@FXML
	TableView<Aresta> tbl;

	@FXML
	TableColumn<Aresta, String> colOrigem;
	@FXML
	TableColumn<Aresta, String> colDestino;
	@FXML
	TableColumn<Aresta, Number> colValor;

	ArrayList<Vertice> verticeLista = new ArrayList<Vertice>();
	ArrayList<Aresta> arestaLista = new ArrayList<Aresta>();
	boolean valorado, orientado;
	FilaAresta filaAresta = new FilaAresta();
	Vertice source;

	@FXML
	public void initialize() {
		inicializaTbl();
		lerArquivoProperties();
		leVertice();
		leAresta();

	}

	private void inicializaTbl() {
		colOrigem.setCellValueFactory(cellData -> cellData.getValue().origemProperty());
		colDestino.setCellValueFactory(cellData -> cellData.getValue().destinoProperty());
		colValor.setCellValueFactory(cellData -> cellData.getValue().valorProperty());

	}

	public String nomeAresta(Aresta aresta) {
		
		String nome = aresta.getOrigem().concat(aresta.getDestino());
		return nome;
	}
	
	
	public void kruskal() {
		
		insereValorPrioridade();
	//	Aresta aresta = filaAresta.remove();
		for (Vertice vertice : verticeLista) {
			vertice.getConjunto().add(vertice);	
		
			
			
		}
		
		
	}
	
	
	public void lalsalsa(String nome, Vertice vertice) {
		
		
		
		ArrayList<Vertice> nome = new ArrayList<>();
		
		
	}


	public void prim() {

		source();

	}

	public void insereValorPrioridade() {

		for (Aresta aresta : arestaLista) {
			filaAresta.inserePrioridade(aresta);
		}
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
	public void source() {

		for (Vertice vertice : verticeLista) {
			if (vertice.getNome().equalsIgnoreCase(txtSource.getText())) {
				source = vertice;
			}
		}
		source.setDistancia(0);
		fila.insere(source);
		txtSource.setText("");
	}
}
