package all;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.Timer;
///Os botoes vao chamar timer, e timer chama o handler;
public class Metronomo implements ActionListener{
	private Timer metro;
	private int intervalo;
	JButton start, stop, speed, slow;
	GUIGrid tab;
	Window window;
	Handler handler;
	
	public Metronomo(JButton start, JButton stop, JButton speed, JButton slow, int intervalo, GUIGrid tab, Window window) {
		this.start=start;
		this.stop=stop;
		this.speed=speed;
		this.slow=slow;
		this.intervalo=intervalo;
		this.window=window;
		this.tab=tab;
		metro = new Timer(intervalo, this);
		this.handler= new Handler(tab, window);
		metro.addActionListener(handler);
	}
	
	public void start() {
		metro.start();
	   }
	    
	public void stop() {
		metro.stop();
    }
	
	public void speed() {
		intervalo-=100;
		metro= new Timer(intervalo, this);
		metro.addActionListener(handler); //Talvez seja inutil fazer isso, mas nao sei se o action listener se mantem apos criar um novo metro.
	}
	
	public void slow() {
		intervalo+=100;
		metro= new Timer(intervalo, this);
		metro.addActionListener(handler); //Talvez seja inutil fazer isso, mas nao sei se o action listener se mantem apos criar um novo metro.
	}
	
	public void actionPerformed(ActionEvent evento) { //Acho que ele nao esta passando o evento para o handler..
		if (evento.getSource()==start) {
			start();
		}
		else if (evento.getSource()==stop) {
			stop();
		}
		else if (evento.getSource()==speed) {
			speed();
		}
		else if (evento.getSource()==slow) {
			slow();
		}
   }
}