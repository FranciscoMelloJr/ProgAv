package application;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import model.Trabalhador;

public class Tela1Controller {
	
	@FXML TextField t1QT;
	@FXML TextField t1Tempo;
	@FXML TextField t2QT;
	@FXML TextField t2Tempo;
	@FXML ProgressBar bar1;
	@FXML ProgressBar bar2;
	
	
	@FXML
	public void iniciaSemThread() {
		int qt1 = Integer.parseInt(t1QT.getText()); 
		int qt2 = Integer.parseInt(t2QT.getText()); 
		int tp1 = Integer.parseInt(t1Tempo.getText()); 
		int tp2 = Integer.parseInt(t2Tempo.getText());
		Trabalhador t1 = new Trabalhador(qt1, tp1, bar1);
		Trabalhador t2 = new Trabalhador(qt2, tp2, bar2);
		t1.inicia();
		t2.inicia();
		
	}
	
	@FXML
	public void iniciaComThread() {
		int qt1 = Integer.parseInt(t1QT.getText()); 
		int qt2 = Integer.parseInt(t2QT.getText()); 
		int tp1 = Integer.parseInt(t1Tempo.getText()); 
		int tp2 = Integer.parseInt(t2Tempo.getText());
		Trabalhador t1 = new Trabalhador(qt1, tp1, bar1);
		Trabalhador t2 = new Trabalhador(qt2, tp2, bar2);
		new Thread(t1).start();
		new Thread(t2).start();
	}
	
	

}
