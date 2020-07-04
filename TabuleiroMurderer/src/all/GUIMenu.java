package all;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GUIMenu extends JPanel{
	private static final long serialVersionUID = -3599809291952997126L;
	JButton play, stopmusic, credits, instructions, quit;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	ImageIcon bg = new ImageIcon(DIRETORIO + "background.png");
	Window window;
	Music music;
	
	public GUIMenu(Window window) {
		super();
		//Vai ter um background tbm :D
		this.window=window;
		this.music = window.music;
		this.setLayout(null);
		JLabel img=new JLabel(bg);
		play= new JButton("Play");
		stopmusic= new JButton("Toggle Music");
		instructions= new JButton("Instructions");
		credits= new JButton("Credits");
		quit= new JButton("Quit");
		Insets insets = this.getInsets();
		
		Dimension size = play.getPreferredSize();
		play.setBounds(200 + insets.left, 25 + insets.top, size.width + 50, size.height + 20);
		this.add(play);
		
		size = stopmusic.getPreferredSize();
		stopmusic.setBounds(200 + insets.left, 100 + insets.top, size.width +50, size.height +20);
		this.add(stopmusic);
		
		size = instructions.getPreferredSize();
		instructions.setBounds(200 + insets.left, 175 + insets.top, size.width +50, size.height +20);
		this.add(instructions);
		
		size = credits.getPreferredSize();
		credits.setBounds(200 + insets.left, 250 + insets.top, size.width +50, size.height +20);
		this.add(credits);
		
		
		size = quit.getPreferredSize();
		quit.setBounds(200 + insets.left, 325 + insets.top, size.width +50, size.height +20);
		this.add(quit);
		
		size = img.getPreferredSize();
		img.setBounds(insets.left,insets.top, size.width, size.height); //Talvez seja (0,0, size.width, size.height);
		this.add(img);
		
		play.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               window.win.removeAll();
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
		               window.win.removeAll();
		               GUIInstructions inst = new GUIInstructions(window);
		               window.win.add(inst, BorderLayout.CENTER);
		            }
		         }
		      );
		credits.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               /*window.win.removeAll();
		               GUICredits cred = new GUICredits();
		               window.win.add(cred, BorderLayout.CENTER);*/
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
