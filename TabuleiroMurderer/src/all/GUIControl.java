
package all;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIControl extends JPanel {
	private static final long serialVersionUID = 3925528830112612821L;
	GUIGrid tab;
	Handler handler;
	Metronomo metro;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	
	ImageIcon startim= new ImageIcon(DIRETORIO+"MenuImages\\"+"Start.png");
	ImageIcon stopim= new ImageIcon(DIRETORIO+"MenuImages\\"+"Stop.png");
	ImageIcon speedim= new ImageIcon(DIRETORIO+"MenuImages\\"+"SpeedUp.png");
	ImageIcon slowim= new ImageIcon(DIRETORIO+"MenuImages\\"+"SlowDown.png");
	
	
	JButton start = new JButton(startim);
	JButton stop = new JButton(stopim);
	JButton speed = new JButton(speedim);
	JButton slow = new JButton(slowim);
	Window window;
	Container win;
	
	public GUIControl(GUIGrid tab, Window window) {
		super(new FlowLayout());
		this.tab=tab;
		this.window=window;
		this.win=window.win;
		this.handler= new Handler(tab, window, this);
		
		start.setPreferredSize(new Dimension(136, 20));
		stop.setPreferredSize(new Dimension(136, 20));
		speed.setPreferredSize(new Dimension(136, 20));
		slow.setPreferredSize(new Dimension(136, 20));
		
		
		metro=new Metronomo(1000, tab, window, this);
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
	
	public void restart() { //O botao restart no GameOver vai chamar essa funcao.
		window.positions[0][0]=0;
        window.positions[0][1]=0;
        window.positions[1][0]=11;
        window.positions[1][1]=11;
        window.positions[2][0]=20;
        window.positions[2][1]=20;
        window.positions[3][0]=20;
        window.positions[3][1]=20;
        window.positions[4][0]=20;
        window.positions[4][1]=20;
        window.positions[5][0]=20;
        window.positions[5][1]=20;
        window.win.removeAll();
        window.control.handlerIni.reset();
        //handler.reset();
        metro.stop();
        window.create();
	}
	
	
}