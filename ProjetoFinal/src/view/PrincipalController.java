package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Properties;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import model.Aresta;
import model.Vertice;

public class PrincipalController {

	@FXML
	TabPane tabPane;
	@FXML
	RadioButton ckOrientado;
	@FXML
	RadioButton ckValorado;

	@FXML
	TextField txtVertice;
	@FXML
	TextField txtOrigem;
	@FXML
	TextField txtDestino;
	@FXML
	TextField txtValor;

	ArrayList<Vertice> verticeLista = new ArrayList<Vertice>();
	ArrayList<Aresta> arestaLista = new ArrayList<Aresta>();

	private void alteraArquivoProperties() {
		Properties propertie = new Properties();
		try (FileReader fr = new FileReader("conf.properties"); BufferedReader br = new BufferedReader(fr)) {
			propertie.load(fr);
			propertie.setProperty("orientado", String.valueOf(ckOrientado.isSelected()));
			propertie.setProperty("valorado", String.valueOf(ckOrientado.isSelected()));

			try (BufferedWriter bw = new BufferedWriter(new FileWriter("conf.properties"))) {
				propertie.store(bw, "Atualização de Configurações");
				bw.close();

			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void inserirAresta() {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("aresta.txt", true))) {

			Aresta aresta = new Aresta();
			aresta.setOrigem(txtOrigem.getText());
			aresta.setDestino(txtDestino.getText());
			if (ckValorado.isSelected())
				aresta.setValor(Integer.parseInt(txtValor.getText()));
			arestaLista.add(aresta);
			adicionaAdjacente(aresta);
			limpaTelaE();
			txtOrigem.requestFocus();

			String origem = String.format("%-5.5s", aresta.getOrigem());
			String destino = String.format("%-5.5s", aresta.getDestino());
			String valor = String.format("%03d", aresta.getValor()).substring(0, 3);

			bufferedWriter.append(origem + destino + valor + "\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inserirVertice() {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("vertice.txt", true))) {

			Vertice vertice = new Vertice();
			vertice.setNome(txtVertice.getText());
			verticeLista.add(vertice);
			txtVertice.setText("");

			String nome = String.format("%-5.5s", vertice.getNome());

			bufferedWriter.append(nome + "\n");

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
						adjacente.getAdj().add(vertice);
					}
				}
			}
		}
	}

	@FXML
	public void adicionaAresta() {

		Aresta aresta = new Aresta();
		aresta.setOrigem(txtOrigem.getText());
		aresta.setDestino(txtDestino.getText());
		if (ckValorado.isSelected())
			aresta.setValor(Integer.parseInt(txtValor.getText()));
		arestaLista.add(aresta);
		adicionaAdjacente(aresta);
		limpaTelaE();
		txtOrigem.requestFocus();
	}

	@FXML
	public void adicionaVertice() {

		Vertice vertice = new Vertice();
		vertice.setNome(txtVertice.getText());
		verticeLista.add(vertice);
		txtVertice.setText("");

	}

	@FXML
	public void limpaTelaE() {

		txtOrigem.setText("");
		txtValor.setText("");
		txtDestino.setText("");

	}

	@FXML
	public void focusValor() {
		txtValor.requestFocus();
	}

	@FXML
	public void focusDestino() {
		txtDestino.requestFocus();

	}

	@FXML
	public void abreAdjacenciaIncidencia() {
		alteraArquivoProperties() ;
		abreTab("Matriz/Lista", "ListaMatriz.fxml");
	}

	@FXML
	public void abreDistancia() {
		alteraArquivoProperties();
		abreTab("Matriz", "Distancia.fxml");
	}

	@FXML
	public void abreCaminhoMinimo() {
		alteraArquivoProperties();
		abreTab("Caminho Minímo", "CaminhoMinimo.fxml");
	}

	@FXML
	public void abre() {

	}

	private void abreTab(String titulo, String path) {
		try {
			Tab tab = tabAberta(titulo);
			if (tab == null) {
				tab = new Tab(titulo);
				tab.setClosable(true);
				tabPane.getTabs().add(tab);
				tab.setContent((Node) FXMLLoader.load(getClass().getResource(path)));
			}
			selecionaTab(tab);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Tab tabAberta(String titulo) {
		for (Tab tab : tabPane.getTabs()) {
			if (!(tab.getText() == null) && tab.getText().equals(titulo)) {
				return tab;
			}
		}
		return null;
	}

	private void selecionaTab(Tab tab) {
		tabPane.getSelectionModel().select(tab);
	}

}
