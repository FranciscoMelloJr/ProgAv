package model;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;

public class Trabalhador extends Task<Void>{
	
	private int qt;
	private int tempo;
	private ProgressBar barra;
	
	
	
	public Trabalhador(int qt, int tempo, ProgressBar barra) {
		this.qt = qt;
		this.tempo = tempo;
		this.barra = barra;
		barra.setProgress(0);
	}
	
	public void inicia() {
		double incremento = 1.0/qt;
		for(int i=0; i<qt; i++){
			try {
				Thread.sleep(tempo);
				barra.setProgress(barra.getProgress()+incremento);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
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

	@Override
	protected Void call() throws Exception {
		double incremento = 1.0/qt;
		for(int i=0; i<qt; i++){
			try {
				Thread.sleep(tempo);
				Platform.runLater(()-> {
					barra.setProgress(barra.getProgress()+incremento);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
	
	

}
