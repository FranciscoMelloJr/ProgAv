package view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.aluno.Aluno;
import model.aluno.AlunoServiceImpl;

public class CadastroController {
	
	@FXML TextField txtNome;
	@FXML TextField txtFiltro;
	
	@FXML ComboBox<String> chUf;
	
	@FXML TableView<Object> tableView;
	@FXML TableColumn<Aluno, String> colNome;
	
	private AlunoServiceImpl alunoService = new AlunoServiceImpl();
	private List<Aluno> alunos = new ArrayList<>();
	

	@FXML
	public void initialize() {
		alunoService.initialize(colNome,chUf);
	}
	
	@FXML
	public void cadastrarAluno() {
		Aluno aluno = alunoService.objectMap(txtNome,chUf);
		Aluno salvo = alunoService.cadastrarAluno(aluno);
		alunos.add(salvo);
		tableView.setItems(FXCollections.observableArrayList(alunos));
	}
	
	@FXML
	public void filtrar() {
		tableView.setItems(FXCollections.observableArrayList(
				alunos.stream().filter(a -> a.getNome().equals(txtFiltro.getText())).collect(Collectors.toList())));
		
	}

}
