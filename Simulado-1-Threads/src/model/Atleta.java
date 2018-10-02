package model;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;

public class Atleta extends Task<Void> {

	private int distancia;
	private int tempo;
	private ProgressBar barra;

	public Atleta(int distancia, int tempo, ProgressBar barra) {
		super();
		this.distancia = distancia;
		this.tempo = tempo;
		this.barra = barra;
	}

	public void inicia() {
		double incremento = 1.0 / distancia;
		for (int i = 0; i < getDistancia(); i++) {
			try {
				Thread.sleep(tempo);
				barra.setProgress(barra.getProgress() + incremento);

			} catch (Exception e) {
				System.out.println("DEU ERRO SEU MERDA");
				e.printStackTrace();
			}
		}
	}

	@Override
	protected Void call() throws Exception {
		double incremento = 1.0 / distancia;
		for (int i = 0; i < getDistancia(); i++) {
			try {
				Thread.sleep(tempo);
				Platform.runLater(() -> {
					barra.setProgress(barra.getProgress() + incremento);
				});
			} catch (Exception e) {
				System.out.println("DEU ERRO SEU MERDA");
				e.printStackTrace();
			}
		}
		return null;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public ProgressBar getBarra() {
		return barra;
	}

	public void setBarra(ProgressBar barra) {
		this.barra = barra;
	}

}
