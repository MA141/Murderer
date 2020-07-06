package all;

import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class GUIMenu extends JPanel{
	private static final long serialVersionUID = -3599809291952997126L;
	JButton play, stopmusic, credits, instructions, quit;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	ImageIcon bg = new ImageIcon(DIRETORIO +"MenuImages\\"+ "background.png");
	Window window;
	Music music;
	Container win;
	public GUIMenu(Window window) {
		super();
		
		this.window=window;
		this.win=window.getWin();
		this.music = window.getMusic();
		this.setLayout(null);
		JLabel img=new JLabel(bg);
		
		ImageIcon playim= new ImageIcon(DIRETORIO+"MenuImages\\"+"play.png");
		ImageIcon helpim= new ImageIcon(DIRETORIO+"MenuImages\\"+"help.png");
		ImageIcon creditim= new ImageIcon(DIRETORIO+"MenuImages\\"+"credits.png");
		ImageIcon stopim= new ImageIcon(DIRETORIO+"MenuImages\\"+"togglemusic.png");
		ImageIcon quitim= new ImageIcon(DIRETORIO+"MenuImages\\"+"quit.png");
		
		play= new JButton(playim);
		stopmusic= new JButton(stopim);
		instructions= new JButton(helpim);
		credits= new JButton(creditim);
		quit= new JButton(quitim);
		Insets insets = this.getInsets();
		
		
		play.setBounds(235 + insets.left, 150 + insets.top, 130, 40);
		this.add(play);
		
		
		stopmusic.setBounds(235 + insets.left, 200 + insets.top, 130, 40);
		this.add(stopmusic);
		
	
		instructions.setBounds(235 + insets.left, 250 + insets.top, 130, 40);
		this.add(instructions);
		
	
		credits.setBounds(235 + insets.left, 300 + insets.top,130, 40);
		this.add(credits);
		
		
	
		quit.setBounds(235 + insets.left, 350 + insets.top, 130, 40);
		this.add(quit);
		
	
		img.setBounds(-10,-20, 620, 680); 
		this.add(img);
		
		play.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               win.removeAll();
		               window.create();
		            }
		         }
		      );
		
		stopmusic.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	music.toggle();
		            }
		         }
		      );
		
		instructions.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               win.removeAll();
		               GUIInstructions inst = new GUIInstructions(window);
		               win.add(inst, BorderLayout.CENTER);
		               
		               SwingUtilities.updateComponentTreeUI(win);
		            }
		         }
		      );
		credits.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               win.removeAll();
		               GUICredits cred = new GUICredits(window);
		               win.add(cred, BorderLayout.CENTER);
		               SwingUtilities.updateComponentTreeUI(win);
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
