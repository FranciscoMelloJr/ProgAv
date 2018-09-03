package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente {

	private StringProperty  nome  = new SimpleStringProperty("");
	private StringProperty  cidade  = new SimpleStringProperty("");
	private BooleanProperty cart   = new SimpleBooleanProperty(false);
	private BooleanProperty bol   = new SimpleBooleanProperty(false);
	private BooleanProperty dep   = new SimpleBooleanProperty(false);
	
	public StringProperty nomeProperty() {
		return this.nome;
	}
	
	public String getNome() {
		return this.nomeProperty().get();
	}
	
	public void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public StringProperty cidadeProperty() {
		return this.cidade;
	}
	
	public String getCidade() {
		return this.cidadeProperty().get();
	}
	
	public void setCidade(final String cidade) {
		this.cidadeProperty().set(cidade);
	}
	
	public BooleanProperty cartProperty() {
		return this.cart;
	}
	
	public boolean isCart() {
		return this.cartProperty().get();
	}
	
	public void setCart(final boolean cart) {
		this.cartProperty().set(cart);
	}
	
	public BooleanProperty bolProperty() {
		return this.bol;
	}
	
	public boolean isBol() {
		return this.bolProperty().get();
	}
	
	public void setBol(final boolean bol) {
		this.bolProperty().set(bol);
	}
	
	public BooleanProperty depProperty() {
		return this.dep;
	}
	
	public boolean isDep() {
		return this.depProperty().get();
	}
	
	public void setDep(final boolean dep) {
		this.depProperty().set(dep);
	}
}
