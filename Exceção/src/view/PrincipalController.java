package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class PrincipalController {

	@FXML
	TextField txtTamanho;
	@FXML
	TextField txtNumero;
	@FXML
	TextField txtPosicao;

	private int[] vetor;

	@FXML
	public void instanciar() {
		try {
			int tamanho = Integer.parseInt(txtTamanho.getText());
			if (tamanho > 10)
				throw new NumberFormatException("Limite 10");
			vetor = new int[tamanho];
		} catch (NumberFormatException e) {
			mostraMensagem("Erro do tamanho do vetor\n" + e.getMessage(), AlertType.ERROR);
			txtTamanho.requestFocus();
			txtTamanho.selectAll();
		} catch (NegativeArraySizeException e) {
			mostraMensagem("Não pode ser negativo", AlertType.ERROR);
			txtTamanho.requestFocus();
			txtTamanho.selectAll();
		} catch (Exception e) {
			mostraMensagem("Erro não identificado", AlertType.WARNING);
		}

	}

	@FXML
	public void inserir() {
		try {

			int numero = Integer.parseInt(txtNumero.getText());
			int posicao = Integer.parseInt(txtPosicao.getText());
			insereNoVetor(posicao, numero);
			// vetor[posicao] = numero;
			mostraMensagem("Numero inserido com sucesso", AlertType.INFORMATION);

		} catch (NumberFormatException e) {
			mostraMensagem("Erro de conversãao numerica", AlertType.ERROR);
		} catch (NegativeArraySizeException e) {
			mostraMensagem("Campo POSIÇÂO não pode ser negativo", AlertType.ERROR);
		} catch (NullPointerException e) {
			mostraMensagem("Vetor não instanciado", AlertType.ERROR);
		} catch (ArrayIndexOutOfBoundsException e) {
			mostraMensagem("Posição não existe no vetor no método", AlertType.ERROR);
		} catch (Exception e) {
			mostraMensagem("Erro não identificado", AlertType.WARNING);
		}// finally {
			//mostraMensagem("Fim do programa", AlertType.INFORMATION);
	//	}
	}

	public void insereNoVetor(int pos, int nr) throws ArrayIndexOutOfBoundsException {
		try {
			vetor[pos] = nr;
		} catch (ArrayIndexOutOfBoundsException e) {
			mostraMensagem("Posição não existe no vetor", AlertType.ERROR);
			throw e;
		}
	}

	public void mostraMensagem(String msg, AlertType tipo) {
		Alert a = new Alert(tipo);
		a.setHeaderText(null);
		a.setContentText(msg);
		a.show();

	}

}
