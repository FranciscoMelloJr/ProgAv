package model.aluno;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class AlunoServiceImpl implements AlunoService{
	
	 AlunoRepository alunoRepository =  new AlunoRepository();
	
	@Override
	public Aluno cadastrarAluno(Aluno aluno) {
		return alunoRepository.salvar(aluno);
	}
	
	@Override
	public Aluno objectMap(TextField txtNome, ComboBox<String> chUf) {
		try {
			return Aluno.builder()
					.nome(new SimpleStringProperty(txtNome.getText()))
					.build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void initialize(TableColumn<Aluno, String> colNome, ComboBox<String> chUf) {
		inicializaTable(colNome);
		inicializaComboUf(chUf);
	}
	
	private void inicializaTable(TableColumn<Aluno, String> colNome) {
		colNome.setCellValueFactory(cellData -> cellData.getValue().getNome());
	}
	
	private void inicializaComboUf(ComboBox<String> chUf) {
		chUf.getItems().add("SC");
		chUf.getItems().add("AC");
		chUf.getItems().add("PR");
		chUf.getItems().add("RJ");
		chUf.getItems().add("SP");
		chUf.getItems().add("BA");
		
		chUf.getSelectionModel().select(0);
	}
}
