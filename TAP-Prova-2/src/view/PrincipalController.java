package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Aluno;

public class PrincipalController {

	@FXML
	TextField txtNome;
	@FXML
	TextField txtDisciplina;
	@FXML
	TextField txtNota1;
	@FXML
	TextField txtNota2;
	@FXML
	TextField txtNota3;

	@FXML
	Label txtInstituicaoEnsino;
	@FXML
	Label txtMediaA;
	@FXML
	Label txtMediaR;

	@FXML
	TableView<Aluno> tbl;
	@FXML
	TableColumn<Aluno, String> colNome;
	@FXML
	TableColumn<Aluno, String> colDisciplina;
	@FXML
	TableColumn<Aluno, Number> colMedia;
	@FXML
	TableColumn<Aluno, String> colSituacao;

	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

	@FXML
	public void initialize() {
		lerArquivoProperties();
		inicializaTabela();
		lerArquivoDados();
	}

	@FXML
	public void cadastrar() {
		inserir();
		lerArquivoDados();
		limparTela();
	}

	public void lerArquivoDados() {

		alunos.clear();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("dados.txt"))) {

			String linha = "";

			while ((linha = bufferedReader.readLine()) != null) {

				String nome = linha.substring(0, 20);
				String disciplina = linha.substring(20, 35);

				String Nota1AntesVirgula = linha.substring(35, 37);
				String nota1DepoisVirgula = linha.substring(37, 39);
				String nota1 = Nota1AntesVirgula + "." + nota1DepoisVirgula;
				
				String Nota2AntesVirgula = linha.substring(39, 41);
				String nota2DepoisVirgula = linha.substring(41, 43);
				String nota2 = Nota2AntesVirgula + "." + nota2DepoisVirgula;

				String Nota3AntesVirgula = linha.substring(43, 45);
				String nota3DepoisVirgula = linha.substring(45, 47);
				String nota3 = Nota3AntesVirgula + "." + nota3DepoisVirgula;
				
				Aluno aluno = new Aluno();
				aluno.setNome(nome);
				aluno.setDisciplina(disciplina);
				aluno.setMedia(calculaMedia(nota1, nota2, nota3));
				aluno.setSituacao(situacao(aluno.getMedia()));
				alunos.add(aluno);
			}

			tbl.setItems(FXCollections.observableArrayList(alunos));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inserir() {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("dados.txt", true))) {

			Aluno aluno = new Aluno();
			aluno.setNome(txtNome.getText());
			aluno.setDisciplina(txtDisciplina.getText());
			aluno.setNota1(Double.parseDouble(txtNota1.getText()));
			aluno.setNota2(Double.parseDouble(txtNota2.getText()));
			aluno.setNota3(Double.parseDouble(txtNota3.getText()));

			String nome = String.format("%-20.20s", aluno.getNome());
			String disciplina = String.format("%-15.15s", aluno.getDisciplina());
			String nota1 = String.format("%05.2f", aluno.getNota1()).substring(0, 5).replace(",", "");
			String nota2 = String.format("%05.2f", aluno.getNota2()).substring(0, 5).replace(",", "");
			String nota3 = String.format("%05.2f", aluno.getNota3()).substring(0, 5).replace(",", "");

			bufferedWriter.append(nome + disciplina + nota1 + nota2 + nota3 + "\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
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

	private void inicializaTabela() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colDisciplina.setCellValueFactory(cellData -> cellData.getValue().disciplinaProperty());
		colMedia.setCellValueFactory(cellData -> cellData.getValue().mediaProperty());
		colSituacao.setCellValueFactory(cellData -> cellData.getValue().situacaoProperty());
	}

	public String situacao(double media) {

		String situacao = "";
		int mediaA = Integer.parseInt(txtMediaA.getText());
		int mediaR = Integer.parseInt(txtMediaR.getText());

		if (media >= mediaA) {
			situacao = "Aprovado";
		} else if ((media < mediaA) && (media > mediaR)) {
			situacao = "Recuperação";
		} else
			situacao = "Reprovado";
		return situacao;
	}

	public double calculaMedia(String nota1, String nota2, String nota3) {

		
		double media = (Double.parseDouble(nota1) + Double.parseDouble(nota2) + Double.parseDouble(nota3)) / 3;

		return media;
	}

	public void limparTela() {

		txtNome.setText("");
		txtDisciplina.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
	}

}
