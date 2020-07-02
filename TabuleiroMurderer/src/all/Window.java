package all;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Window extends JFrame{
	private static final long serialVersionUID = -6913275480151879642L;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	
	public Murderer murderer;
	public Survivor survivor;
	public int[][] positions;
	Container win;
	
	public Window(int[][] positions,Murderer murderer,Survivor survivor) {
		super();
		this.positions=positions;
		this.survivor=survivor;
		this.murderer=murderer;

        setSize(580, 470); //Precisa arrumar a resolução.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        win = new Container();
        win = getContentPane();
        win.setLayout(new BorderLayout());
        
        GUIGrid tab = new GUIGrid(this);
        win.add(tab, BorderLayout.NORTH);
        
        String text1 = new String("Escolha as coordenada da primeira peça do radio");
        GUIFlowText control = new GUIFlowText(tab, this, text1);
        win.add(control, BorderLayout.SOUTH);
        
        
        setVisible(true);
	}
	
	public Container getWin() {
		return win;
	}
	
}