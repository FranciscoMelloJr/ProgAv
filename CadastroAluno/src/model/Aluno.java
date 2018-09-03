package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aluno {


	private StringProperty  nome  = new SimpleStringProperty("");
	private StringProperty  sexo  = new SimpleStringProperty("");
	private StringProperty  nasc  = new SimpleStringProperty("");
	private StringProperty  uf    = new SimpleStringProperty("");
	private BooleanProperty mat   = new SimpleBooleanProperty(false);
	private BooleanProperty ves   = new SimpleBooleanProperty(false);
	private BooleanProperty not   = new SimpleBooleanProperty(false);
	private IntegerProperty idade = new SimpleIntegerProperty(0);
	
		
	public StringProperty nomeProperty() {
		return this.nome;
	}
	
	public String getNome() {
		return this.nomeProperty().get();
	}
	
	public void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public StringProperty sexoProperty() {
		return this.sexo;
	}
	
	public String getSexo() {
		return this.sexoProperty().get();
	}
	
	public void setSexo(final String sexo) {
		this.sexoProperty().set(sexo);
	}
	
	public StringProperty nascProperty() {
		return this.nasc;
	}
	
	public String getNasc() {
		return this.nascProperty().get();
	}
	
	public void setNasc(final String nasc) {
		this.nascProperty().set(nasc);
	}
	
	public StringProperty ufProperty() {
		return this.uf;
	}
	
	public String getUf() {
		return this.ufProperty().get();
	}
	
	public void setUf(final String uf) {
		this.ufProperty().set(uf);
	}
	
	public BooleanProperty matProperty() {
		return this.mat;
	}
	
	public boolean isMat() {
		return this.matProperty().get();
	}
	
	public void setMat(final boolean mat) {
		this.matProperty().set(mat);
	}
	
	public BooleanProperty vesProperty() {
		return this.ves;
	}
	
	public boolean isVes() {
		return this.vesProperty().get();
	}
	
	public void setVes(final boolean ves) {
		this.vesProperty().set(ves);
	}
	
	public BooleanProperty notProperty() {
		return this.not;
	}
	
	public boolean isNot() {
		return this.notProperty().get();
	}
	
	public void setNot(final boolean not) {
		this.notProperty().set(not);
	}

	public IntegerProperty idadeProperty() {
		return this.idade;
	}
	
	public int getIdade() {
		return this.idadeProperty().get();
	}
	
	public void setIdade(final int idade) {
		this.idadeProperty().set(idade);
	}
}
