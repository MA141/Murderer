package all;


import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GUIGameOver extends JPanel{
	private static final long serialVersionUID = 2985670265302550444L;
	GUIControl cont;
	JButton replay, quit;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	
	
	
	public GUIGameOver(GUIControl cont, int winner) {
		super();
		setSize(620,680);
		this.setLayout(null);
		this.cont=cont;
		
		Insets insets = this.getInsets();
		ImageIcon murdwin = new ImageIcon(DIRETORIO + "MenuImages\\" + "GOMurdererWins.png");
		ImageIcon survwin = new ImageIcon(DIRETORIO + "MenuImages\\" + "GOSurvivorWins.png");
		ImageIcon replayim = new ImageIcon(DIRETORIO + "MenuImages\\" + "PlayAgain.png");
		ImageIcon quitim= new ImageIcon(DIRETORIO + "MenuImages\\" + "Quit.png");
		
		replay = new JButton(replayim); 
		quit = new JButton(quitim); 
		
		
		replay.setBounds(120+ insets.left, 560+ insets.top, 180, 35);
		quit.setBounds(360+ insets.left, 560+ insets.top, 125, 35);
		this.add(replay);
		this.add(quit);
		
		if (winner==1) { //Murderer venceu
			
		
			
			
			JLabel imgMurd=new JLabel(murdwin);
			imgMurd.setBounds(-10,-10,620,680);
			this.add(imgMurd);
		}
		else { //Survivor venceu
			
			
			JLabel imgSurv=new JLabel(survwin);
			imgSurv.setBounds(0,0,620,680);
			this.add(imgSurv);
		}
		
		replay.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               
		               cont.restart();
		            }
		         }
		      );
		
		quit.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		       
		            	System.exit(0);
		            }
		         }
		      );
	}
}
