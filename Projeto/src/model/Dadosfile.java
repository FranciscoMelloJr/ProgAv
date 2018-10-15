package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Dadosfile {

	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty tamanho = new SimpleStringProperty("");
	private StringProperty path = new SimpleStringProperty("");

	public final StringProperty nomeProperty() {
		return this.nome;
	}
	
	public final String getNome() {
		return this.nomeProperty().get();
	}
	
	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public final StringProperty tamanhoProperty() {
		return this.tamanho;
	}
	
	public final String getTamanho() {
		return this.tamanhoProperty().get();
	}
	
	public final void setTamanho(final String tamanho) {
		this.tamanhoProperty().set(tamanho);
	}

	public final StringProperty pathProperty() {
		return this.path;
	}
	

	public final String getPath() {
		return this.pathProperty().get();
	}
	

	public final void setPath(final String path) {
		this.pathProperty().set(path);
	}
	
	
}
