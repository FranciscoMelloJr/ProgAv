package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Aluno {

	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty disciplina = new SimpleStringProperty("");
	private DoubleProperty media = new SimpleDoubleProperty(0);
	private StringProperty situacao = new SimpleStringProperty("");
	private DoubleProperty nota1 = new SimpleDoubleProperty(0);
	private DoubleProperty nota2 = new SimpleDoubleProperty(0);
	private DoubleProperty nota3 = new SimpleDoubleProperty(0);
	
	public final StringProperty nomeProperty() {
		return this.nome;
	}
	
	public final String getNome() {
		return this.nomeProperty().get();
	}
	
	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	
	public final StringProperty disciplinaProperty() {
		return this.disciplina;
	}
	
	public final String getDisciplina() {
		return this.disciplinaProperty().get();
	}
	
	public final void setDisciplina(final String disciplina) {
		this.disciplinaProperty().set(disciplina);
	}
	
	public final DoubleProperty mediaProperty() {
		return this.media;
	}
	
	public final double getMedia() {
		return this.mediaProperty().get();
	}
	
	public final void setMedia(final double media) {
		this.mediaProperty().set(media);
	}
	
	public final StringProperty situacaoProperty() {
		return this.situacao;
	}
	
	public final String getSituacao() {
		return this.situacaoProperty().get();
	}
	
	public final void setSituacao(final String situacao) {
		this.situacaoProperty().set(situacao);
	}

	public final DoubleProperty nota1Property() {
		return this.nota1;
	}
	
	public final double getNota1() {
		return this.nota1Property().get();
	}
	
	public final void setNota1(final double nota1) {
		this.nota1Property().set(nota1);
	}
	
	public final DoubleProperty nota2Property() {
		return this.nota2;
	}
	
	public final double getNota2() {
		return this.nota2Property().get();
	}
	
	public final void setNota2(final double nota2) {
		this.nota2Property().set(nota2);
	}
	
	public final DoubleProperty nota3Property() {
		return this.nota3;
	}

	public final double getNota3() {
		return this.nota3Property().get();
	}

	public final void setNota3(final double nota3) {
		this.nota3Property().set(nota3);
	}
	
}
