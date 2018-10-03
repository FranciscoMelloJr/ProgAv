package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Competicao {

	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty data = new SimpleStringProperty("");
	private IntegerProperty distancia = new SimpleIntegerProperty();
	private IntegerProperty colocação = new SimpleIntegerProperty();

	@Override
	public String toString() {

		return "Nome: " + nome + "Data: " + data + "Distância: " + distancia + "Colocação:" + colocação;
	}

	public final StringProperty nomeProperty() {
		return this.nome;
	}

	public final String getNome() {
		return this.nomeProperty().get();
	}

	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}

	public final StringProperty dataProperty() {
		return this.data;
	}

	public final String getData() {
		return this.dataProperty().get();
	}

	public final void setData(final String data) {
		this.dataProperty().set(data);
	}

	public final IntegerProperty colocaçãoProperty() {
		return this.colocação;
	}

	public final int getColocação() {
		return this.colocaçãoProperty().get();
	}

	public final void setColocação(final int colocação) {
		this.colocaçãoProperty().set(colocação);
	}

	public final IntegerProperty distanciaProperty() {
		return this.distancia;
	}

	public final int getDistancia() {
		return this.distanciaProperty().get();
	}

	public final void setDistancia(final int distancia) {
		this.distanciaProperty().set(distancia);
	}

}
