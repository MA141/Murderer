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

public class GUICredits extends JPanel {
	private static final long serialVersionUID = -220644972650546199L;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	ImageIcon cred = new ImageIcon(DIRETORIO +"MenuImages\\"+ "credits3.png");
	ImageIcon menu = new ImageIcon(DIRETORIO +"MenuImages\\"+ "menu.png");
	JButton back = new JButton(menu); //Trocar por uma imagem.
	Window window;
	Container win;
	
	public GUICredits(Window window) {
		super();
		this.window=window;
		this.win=window.getWin();
		setSize(620, 680);
		this.setLayout(null);
		this.add(back);
		Insets insets = this.getInsets();
		back.setBounds(10 + insets.left,590 + insets.top, 130, 30);
		JLabel img=new JLabel(cred);
		img.setBounds(0,0, 620, 680);
		this.add(img);
		
		
		
		back.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               win.removeAll();
		               GUIMenu menu = new GUIMenu(window);
		               win.add(menu, BorderLayout.CENTER);
		               SwingUtilities.updateComponentTreeUI(window);
		            }
		         }
		      );
	}

}
