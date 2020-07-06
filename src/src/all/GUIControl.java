
package all;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


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
	JTextArea ammo;
	
	JButton start = new JButton(startim);
	JButton stop = new JButton(stopim);
	JButton speed = new JButton(speedim);
	JButton slow = new JButton(slowim);
	Window window;
	Container win;
	ITable table;
	
	public GUIControl(ITable table) {
		super(new FlowLayout());
		this.table=table;
		this.tab=table.getGrid();
		this.window=table.getWindow();
		this.win=window.getWin();
		this.handler= new Handler(table, this);
		
		start.setPreferredSize(new Dimension(136, 20));
		stop.setPreferredSize(new Dimension(136, 20));
		speed.setPreferredSize(new Dimension(136, 20));
		slow.setPreferredSize(new Dimension(136, 20));
		
		
		metro=new Metronomo(1000, table, this);
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
		int[][] pos= window.getPositions();
		
		pos[0][0]=0;
		pos[0][1]=0;
		pos[1][0]=11;
		pos[1][1]=11;
		pos[2][0]=20;
		pos[2][1]=20;
		pos[3][0]=20;
		pos[3][1]=20;
		pos[4][0]=20;
		pos[4][1]=20;
		pos[5][0]=20;
		pos[5][1]=20;
        win.removeAll();
        window.control.handlerIni.reset();
       
        metro.stop();
        window.create();
	}
	
	
}