package model;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;

public class Funcionario extends Task<Void> {

	private StringProperty nome = new SimpleStringProperty("");
	private IntegerProperty quantidade = new SimpleIntegerProperty();
	private double qnt;
	private IntegerProperty tempo = new SimpleIntegerProperty();
	private double tmp;
	private ProgressBar barra;

	public Funcionario(double qnt, double tmp, ProgressBar barra) {
		super();
		this.qnt = qnt;
		this.tmp = tmp;
		this.barra = barra;
	}

	public Funcionario() {

	}

	public Funcionario(StringProperty nome, IntegerProperty quantidade, IntegerProperty tempo, ProgressBar barra) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.qnt = getQuantidade();
		this.tempo = tempo;
		this.tmp = getTempo();
		this.barra = barra;
	}

	@Override
	protected Void call() throws Exception {
		double incremento = 1.0 / getQnt();	
		for (int i = 0; i < getTmp(); i++) {
			try {
				Thread.sleep((long)getTmp());
				Platform.runLater(() -> {
					barra.setProgress(barra.getProgress() + incremento);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public double getQnt() {
		return qnt;
	}

	public void setQnt(double qnt) {
		this.qnt = qnt;
	}

	public double getTmp() {
		return tmp;
	}

	public void setTmp(double tmp) {
		this.tmp = tmp;
	}

	public ProgressBar getBarra() {
		return barra;
	}

	public void setBarra(ProgressBar barra) {
		this.barra = barra;
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

	public final IntegerProperty quantidadeProperty() {
		return this.quantidade;
	}

	public final int getQuantidade() {
		return this.quantidadeProperty().get();
	}

	public final void setQuantidade(final int quantidade) {
		this.quantidadeProperty().set(quantidade);
	}

	public final IntegerProperty tempoProperty() {
		return this.tempo;
	}

	public final int getTempo() {
		return this.tempoProperty().get();
	}

	public final void setTempo(final int tempo) {
		this.tempoProperty().set(tempo);
	}

}
