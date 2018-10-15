package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aluno {

	private StringProperty nome = new SimpleStringProperty("");
	private IntegerProperty semestre = new SimpleIntegerProperty(0);
	private StringProperty curso = new SimpleStringProperty("");
	
	public final StringProperty nomeProperty() {
		return this.nome;
	}
	
	public final String getNome() {
		return this.nomeProperty().get();
	}
	
	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public final IntegerProperty semestreProperty() {
		return this.semestre;
	}
	
	public final int getSemestre() {
		return this.semestreProperty().get();
	}
	
	public final void setSemestre(final int semestre) {
		this.semestreProperty().set(semestre);
	}
	
	public final StringProperty cursoProperty() {
		return this.curso;
	}
	
	public final String getCurso() {
		return this.cursoProperty().get();
	}
	
	public final void setCurso(final String curso) {
		this.cursoProperty().set(curso);
	}
	

	

}
