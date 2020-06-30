package all;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Window extends JFrame{
	private static final long serialVersionUID = -6913275480151879642L;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	
	public Murderer hunter;
	public Survivor survivor;
	Container win;
	
	public Window(Murderer hunter, Survivor survivor) {
		super();
		this.survivor=survivor;
		this.hunter=hunter;
        setSize(410, 470); //Precisa arrumar a resolução.
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        win = new Container();
        win = getContentPane();
        win.setLayout(new BorderLayout());
        
        GUIGrid tab = new GUIGrid(this);
        win.add(tab, BorderLayout.NORTH);
        
        String text1 = new String("Escolha a coordenada da primeira peça do radio");
        GUIFlowText control = new GUIFlowText(tab, this, text1);
        win.add(control, BorderLayout.SOUTH);
        
        
        setVisible(true);
	}
	
	public Container getWin() {
		return win;
	}
	
}