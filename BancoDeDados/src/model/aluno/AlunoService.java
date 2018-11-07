package model.aluno;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public interface AlunoService {
	
	public Aluno cadastrarAluno(Aluno aluno);
	
	public Aluno objectMap(TextField txtNome, ComboBox<String> chUf);
}
