package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Corredor {

	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty nasc = new SimpleStringProperty("");
	private IntegerProperty peito = new SimpleIntegerProperty();
	private IntegerProperty idade = new SimpleIntegerProperty();
	private IntegerProperty distancia = new SimpleIntegerProperty();
	private SimpleStringProperty faixa = new SimpleStringProperty();

	public final StringProperty nomeProperty() {
		return this.nome;
	}

	public final String getNome() {
		return this.nomeProperty().get();
	}

	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}

	public final IntegerProperty idadeProperty() {
		return this.idade;
	}

	public final int getIdade() {
		return this.idadeProperty().get();
	}

	public final void setIdade(final int idade) {
		this.idadeProperty().set(idade);
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

	public final SimpleStringProperty faixaProperty() {
		return this.faixa;
	}

	public final String getFaixa() {
		return this.faixaProperty().get();
	}

	public final void setFaixa(final String faixa) {
		this.faixaProperty().set(faixa);
	}

	public final StringProperty nascProperty() {
		return this.nasc;
	}

	public final String getNasc() {
		return this.nascProperty().get();
	}

	public final void setNasc(final String nasc) {
		this.nascProperty().set(nasc);
	}

	public final IntegerProperty peitoProperty() {
		return this.peito;
	}

	public final int getPeito() {
		return this.peitoProperty().get();
	}

	public final void setPeito(final int peito) {
		this.peitoProperty().set(peito);
	}

}
