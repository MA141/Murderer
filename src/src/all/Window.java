package all;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;

import javax.swing.SwingUtilities;

public class Window extends JFrame{
	private static final long serialVersionUID = -6913275480151879642L;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	
	private IPieceDynamic murderer;
	private IPieceDynamic survivor;
	public int[][] positions;
	private Music music;
	GUIFlowText control;
	private Container win;
	
	public Window(int[][] positions,IPieceDynamic murderer,IPieceDynamic survivor) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		super();
		this.positions=positions;
		this.survivor=survivor;
		this.murderer=murderer;
		music = new Music();

        setSize(620, 680); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        win = new Container();
        win = getContentPane();
        win.setLayout(new BorderLayout());
        setVisible(true);
        
        //////tela inicial 
        win.add(new Presentation(this),BorderLayout.CENTER);
        win.removeAll();

        /////menu
        GUIMenu menu = new GUIMenu(this);
        win.add(menu, BorderLayout.CENTER);
        SwingUtilities.updateComponentTreeUI(this);
          
	}
	
	public void create() {
		GUIGrid tab = new GUIGrid(this);
        win.add(tab, BorderLayout.NORTH);
        
        String text1 = new String("Choose the position of the first radio part (like this: x,y)");
        ITable table= new Table();
        table.setGrid(tab);
        table.setWindow(this);
        
        control = new GUIFlowText(table, text1);
        win.add(control, BorderLayout.SOUTH);
        
        
        SwingUtilities.updateComponentTreeUI(this);
	}
	public IPieceDynamic getSurvivor() {
		return survivor;
	}
	public IPieceDynamic getMurderer() {
		return murderer;
	}
	
	public int[][] getPositions() {
		return positions;
	}
	
	
	
	public Music getMusic() {
		return music;
	}
	public Container getWin() {
		return win;
	}
	
}