package view;


import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import model.Trabalhor;

public class PrincipalController {
	
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
		Trabalhor t1 = new Trabalhor (qt1, tp1, bar1);
		Trabalhor t2 = new Trabalhor (qt2, tp2, bar1);
		t1.inicia();
		t2.inicia();
	}
	
	@FXML 
	public void iniciaComThread() {
		int qt1 = Integer.parseInt(t1QT.getText());
		int qt2 = Integer.parseInt(t2QT.getText());
		int tp1 = Integer.parseInt(t1Tempo.getText());
		int tp2 = Integer.parseInt(t2Tempo.getText());
		Trabalhor t1 = new Trabalhor (qt1, tp1, bar1);
		Trabalhor t2 = new Trabalhor (qt2, tp2, bar1);
		new Thread(t1).start();
		new Thread(t2).start();
	}
	
}
