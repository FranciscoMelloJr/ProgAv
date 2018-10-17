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
import model.Aluno;

public class AlunoController {

	@FXML
	TextField txtNome;
	@FXML
	TextField txtSemestre;
	@FXML
	TextField txtCurso;

	@FXML
	TableView<Aluno> tbl;
	@FXML
	TableColumn<Aluno, String> colNome;
	@FXML
	TableColumn<Aluno, Number> colSemestre;
	@FXML
	TableColumn<Aluno, String> colCurso;

	private ArrayList<Aluno> alunos = new ArrayList<>();

	@FXML
	public void initialize() {
		inicializaTabela();
		leArquivo();
	}

	private void inicializaTabela() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colSemestre.setCellValueFactory(cellData -> cellData.getValue().semestreProperty());
		colCurso.setCellValueFactory(cellData -> cellData.getValue().cursoProperty());
	}
	
	@FXML
	public void cadastrar() {
		inserir();
		leArquivo();
	}
	
	private void leArquivo() {
		alunos.clear();
		try {
			FileReader fr = new FileReader("alunos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linha = "";
			while((linha = br.readLine())!=null) {
				String[] dados = linha.split(",");
				Aluno a = new Aluno();
				a.setNome(dados[0]);
				a.setSemestre(Integer.parseInt(dados[1]));
				a.setCurso(dados[2]);
				alunos.add(a);
			}
			br.close();
			fr.close();
			tbl.setItems(FXCollections.observableArrayList(alunos));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void inserir() {
		try {
			Aluno a = new Aluno();
			a.setNome(txtNome.getText());
			a.setSemestre(Integer.parseInt(txtSemestre.getText()));
			a.setCurso(txtCurso.getText());
			FileWriter fw = new FileWriter("alunos.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append(a.getNome()+","+a.getSemestre()+","+a.getCurso()+"\n");
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
