package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto {
	
	private IntegerProperty cod = new SimpleIntegerProperty();
	private StringProperty nome = new SimpleStringProperty();
	private DoubleProperty valor = new SimpleDoubleProperty();
	private IntegerProperty quantidade = new SimpleIntegerProperty();
	
	public final IntegerProperty codProperty() {
		return this.cod;
	}
	
	public final int getCod() {
		return this.codProperty().get();
	}
	
	public final void setCod(final int cod) {
		this.codProperty().set(cod);
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
	
	public final DoubleProperty valorProperty() {
		return this.valor;
	}
	
	public final double getValor() {
		return this.valorProperty().get();
	}
	
	public final void setValor(final double valor) {
		this.valorProperty().set(valor);
	}
	
	public final IntegerProperty quantidadeProperty() {
		return this.quantidade;
	}
	
	public final int getQuantidade() {
		return this.quantidadeProperty().get();
	}
	
	public final void setQuantidade(final int quantidade) {
		this.quantidadeProperty().set(quantidade);
	}

}
