
package all;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		metro=new Metronomo(1000, tab, window);
		start.addActionListener(metro);   	this.add(start);
		start.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               metro.start();
		            }
		         }
		      );
		
		stop.addActionListener(metro);   	this.add(stop);
		stop.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               metro.stop();
		            }
		         }
		      );
		
		
		
		speed.addActionListener(metro);   	this.add(speed);
		speed.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               metro.speed();
		            }
		         }
		      );
		
		
		
		slow.addActionListener(metro);   	this.add(slow);
		slow.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               metro.slow();
		            }
		         }
		      );
	}
}