package all;

import java.awt.FlowLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GUIControl extends JPanel {
	private static final long serialVersionUID = 3925528830112612821L;
	GUIGrid tab;
	Handler handler;
	Metronomo metro;
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	JButton speed = new JButton("Speed up");
	JButton slow = new JButton("Slow down");
	Window window;
	Container win;
	
	public GUIControl(GUIGrid tab, Window window) {
		super(new FlowLayout());
		this.tab=tab;
		this.window=window;
		this.win=window.win;
		this.handler= new Handler(tab, window);
		
		metro=new Metronomo(start, stop, speed, slow,1000, tab, window);
		start.addActionListener(metro);   	this.add(start);
		stop.addActionListener(metro);   	this.add(stop);
		speed.addActionListener(metro);   	this.add(speed);
		slow.addActionListener(metro);   	this.add(slow);
	}
}