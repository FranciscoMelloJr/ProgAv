package model;


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Corredor {

	private StringProperty  nome  = new SimpleStringProperty("");
	private StringProperty  nasc  = new SimpleStringProperty("");
	private DoubleProperty  peito  = new SimpleDoubleProperty();
	private IntegerProperty idade = new SimpleIntegerProperty();
	private IntegerProperty distancia = new SimpleIntegerProperty();
	private SimpleStringProperty faixaEtaria = new SimpleStringProperty();
	
	
	public final StringProperty nomeProperty() {
		return this.nome;
	}
	
	public final String getNome() {
		return this.nomeProperty().get();
	}
	
	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
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
	
	public final DoubleProperty peitoProperty() {
		return this.peito;
	}
	
	public final double getPeito() {
		return this.peitoProperty().get();
	}
	
	public final void setPeito(final double peito) {
		this.peitoProperty().set(peito);
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
	
	public final SimpleStringProperty faixaEtariaProperty() {
		return this.faixaEtaria;
	}
	
	public final String getFaixaEtaria() {
		return this.faixaEtariaProperty().get();
	}
	
	public final void setFaixaEtaria(final String faixaEtaria) {
		this.faixaEtariaProperty().set(faixaEtaria);
	}	
	
}
