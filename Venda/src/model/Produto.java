package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Produto {
	
	private StringProperty  nome  = new SimpleStringProperty("");
	private DoubleProperty  valor  = new SimpleDoubleProperty(0.0);
	private IntegerProperty  qnt  = new SimpleIntegerProperty(0);
	private DoubleProperty  sub  = new SimpleDoubleProperty(0.0);
	
	public StringProperty nomeProperty() {
		return this.nome;
	}
	
	public String getNome() {
		return this.nomeProperty().get();
	}
	
	public void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public DoubleProperty valorProperty() {
		return this.valor;
	}
	
	public double getValor() {
		return this.valorProperty().get();
	}
	
	public void setValor(final double valor) {
		this.valorProperty().set(valor);
	}
	
	public IntegerProperty qntProperty() {
		return this.qnt;
	}
	
	public int getQnt() {
		return this.qntProperty().get();
	}
	
	public void setQnt(final int qnt) {
		this.qntProperty().set(qnt);
	}
	
	public DoubleProperty subProperty() {
		return this.sub;
	}
	
	public double getSub() {
		return this.subProperty().get();
	}
	
	public void setSub(final double sub) {
		this.subProperty().set(sub);
	}
}
