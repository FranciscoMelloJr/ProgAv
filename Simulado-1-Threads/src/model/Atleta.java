package model;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;

public class Atleta extends Task<Void> {

	private double distancia;
	private double tempo;
	private ProgressBar barra;

	public Atleta(double distancia, double tempo, ProgressBar barra) {
		super();
		this.distancia = distancia;
		this.tempo = tempo;
		this.barra = barra;
	}

	// Sem thread
	public void inicia() {
		double incremento = 1.0 / distancia;
		for (int i = 0; i < getDistancia(); i++) {
			try {
				Thread.sleep((int)tempo);
				barra.setProgress(barra.getProgress() + incremento);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected Void call() throws Exception {
		double incremento = 1.0 / distancia;
		for (int i = 0; i < getDistancia(); i++) {
			try {
				Thread.sleep((int) tempo);
				Platform.runLater(() -> {
					barra.setProgress(barra.getProgress() + incremento);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public double getTempo() {
		return tempo;
	}

	public void setTempo(double tempo) {
		this.tempo = tempo;
	}

	public ProgressBar getBarra() {
		return barra;
	}

	public void setBarra(ProgressBar barra) {
		this.barra = barra;
	}

}
