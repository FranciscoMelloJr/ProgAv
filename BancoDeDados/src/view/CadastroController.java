package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import util.Conexao;

public class CadastroController {
	
	@FXML TextField txtNome;
	@FXML TextField txtFiltro;
	
	@FXML ComboBox<String> chUf;
	
	@FXML TableView<Object> tableView;
	@FXML TableColumn<Aluno, String> colNome;
	
	private AlunoServiceImpl alunoService = new AlunoServiceImpl();
	private List<Aluno> alunos = new ArrayList<>();
	

	classe CadAlunoController {
		
	TextField txtNome;
	TextField txtIdade;
	ComboBox <Cidade> cbCidade;
	ComboBox <Curso> cbCurso;
	TableView<Aluno> tbl;
	TableCollumn<Aluno,String> colNome;
	TableCollumn<Aluno,Number> colIdade;
	TableCollumn<Aluno,String> colCidade;
	TableCollumn<Aluno,String> colCurso;
	
	@FXML
	public void initialize() {
		alunoService.initialize(colNome,chUf);
		preencheComboCidade();
		preencheComboCurso();
		listaAlunos();
	}
	
	@FXML 
	public void listaAlunos() {
		tbl.getItems().clear();
		try {
			Connection conn = Conexao.getConexao();
			String sql = "Select * from aluno order by nome";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Aluno a = new Alno();
				a.setCodigo(rs.getInt("codigo"));
				a.setNome(rs.getString("nome"));
				a.setIdade(rs.getInt("idade"));
				a.setCidade(buscaCidadePorCodigo(rs.getInt("cidade")));
				a.setCurso(buscaCursoPorCodigo(rs.getInt("curso")));
				tbl.getItens().add(a);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private Cidade buscaCidadePorCodigo(int cod) {
		Cidade c = new Cidade();
		try {
			Connection conn = Conexao.getConexao();
			String sql = "Select * from cidade where codigo=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,cod);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c.setCodigo(rs.getInt("codigo"));
				c.setNome(rs.getString("nome"));
				c.setUf(rs.getString("uf"));
			}
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	private Curso buscaCursoPorCodigo(int cod) {
		Curso c = new Curso();
		try {
			Connection conn = Conexao.getConexao();
			String sql = "Select * from cidade where codigo=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,cod);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c.setCodigo(rs.getInt("codigo"));
				c.setNome(rs.getString("nome"));
			}
			conn.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
		
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
	
	public void cadastra() {
		
		try { //cria objeto aluno
			Aluno = a = new Aluno();
			a.setNome(txtNome.getText())
			a.setIDade(Integer.parseInt(txtIdade.getText()))
			a.setCidade(cbCidade.getSelectionModel().getSelectedItem())
			a.setCurso(cbCurso.getSelectionModel().getSelectedItem())
			Connection conn = Conexao.getConexao();
			String sql = "Insert into alno (nome,idade,cidade,curso) + values (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getNome());
			ps.setInt(2, a.getIdade());
			ps.setInt(3, a.getCidade().getCodigo());
			ps.setInt(4, a.getCurso().getCodigo());
			ps.executeUpdate();
			conn.close();
			listaAlunos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	private void preencheComboCidade() {
		try { 
			Connection conn = Conexao.getConexao();
			String sql = "Select * from cidade order by nome";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet = ps.executeQuery();
			while(rs.next()) {
				Cidade c = new Cidade();
			c.setCodigo(rs.getInt("codigo");
			c.setnome(rs.getString("nome");
			c.setUf(rs.getString("uf");
			cbCidade.getItens().add(c);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
