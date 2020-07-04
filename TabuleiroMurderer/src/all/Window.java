package all;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Window extends JFrame{
	private static final long serialVersionUID = -6913275480151879642L;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	
	public Murderer murderer;
	public Survivor survivor;
	public int[][] positions;
	public Music music;
	Container win;
	
	public Window(int[][] positions,Murderer murderer,Survivor survivor) throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
		super();
		this.positions=positions;
		this.survivor=survivor;
		this.murderer=murderer;
		music = new Music();

        setSize(620, 680); //Precisa arrumar a resolução.
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
        
        
        
        ////
        /*GUIGrid tab = new GUIGrid(this);
        win.add(tab, BorderLayout.NORTH);
        
        String text1 = new String("Escolha as coordenada da primeira peça do radio");
        GUIFlowText control = new GUIFlowText(tab, this, text1);
        win.add(control, BorderLayout.SOUTH);
        
        
        SwingUtilities.updateComponentTreeUI(this);*/
	}
	
	public void create() {
		GUIGrid tab = new GUIGrid(this);
        win.add(tab, BorderLayout.NORTH);
        
        String text1 = new String("Escolha as coordenada da primeira peça do radio");
        GUIFlowText control = new GUIFlowText(tab, this, text1);
        win.add(control, BorderLayout.SOUTH);
        
        
        SwingUtilities.updateComponentTreeUI(this);
	}
	
	public Container getWin() {
		return win;
	}
	
}