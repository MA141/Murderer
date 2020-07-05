package all;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Metronomo implements ActionListener{
	private Timer metro;
	private int intervalo;
	GUIGrid tab;
	Window window;
	Handler handler;
	
	public Metronomo( int intervalo, GUIGrid tab, Window window, GUIControl cont) {
		this.intervalo=intervalo;
		this.window=window;
		this.tab=tab;
		metro = new Timer(intervalo, this);
		handler= new Handler(tab, window, cont);
		metro.addActionListener(handler);
	}
	
	public void start() {
		metro.start();
	   }
	    
	public void stop() {
		metro.stop();
    }
	
	public void speed() {
		if(intervalo>=100) { //Da para colocar um warning dizendo que atingiu a velocidade maxima.
			intervalo-=100;
			metro.setDelay(intervalo);
		}
	}
		
	
	public void slow() {
		intervalo+=100;
		metro.setDelay(intervalo);
	}
	
	public void actionPerformed(ActionEvent evento) { //Acho que ele nao esta passando o evento para o handler..
		//Dummy, as açoes feitas nele foram setadas em GUIControl.
   }
}