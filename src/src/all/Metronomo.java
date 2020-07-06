package all;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Timer;

public class Metronomo implements ActionListener{
	private Timer metro;
	private int intervalo;
	GUIGrid tab;
	Window window;
	Handler handler;
	ITable table;
	
	public Metronomo( int intervalo, ITable table, GUIControl cont) {
		this.intervalo=intervalo;
		this.table=table;
		this.window=table.getWindow();
		this.tab=table.getGrid();
		metro = new Timer(intervalo, this);
		handler= new Handler(table, cont);
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
	
	public void actionPerformed(ActionEvent evento) {
		//Dummy, as açoes feitas nele foram setadas em GUIControl.
   }
}