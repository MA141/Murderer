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
import javax.swing.SwingUtilities;

public class GUICredits extends JPanel {
	private static final long serialVersionUID = -220644972650546199L;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	ImageIcon cred = new ImageIcon(DIRETORIO +"MenuImages\\"+ "credits3.png");
	ImageIcon menu = new ImageIcon(DIRETORIO +"MenuImages\\"+ "menu.png");
	JButton back = new JButton(menu); //Trocar por uma imagem.
	Window window;
	
	public GUICredits(Window window) {
		super();
		this.window=window;
		setSize(620, 680);
		this.setLayout(null);
		
		this.add(back);
		Insets insets = this.getInsets();
		
		Dimension size = back.getPreferredSize();
		back.setBounds(10 + insets.left,590 + insets.top, 130, 30);
		
		JLabel img=new JLabel(cred);
		size = img.getPreferredSize();
		img.setBounds(0,0, 620, 680);
		this.add(img);
		
		
		
		back.addActionListener(
		         new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		               window.win.removeAll();
		               GUIMenu menu = new GUIMenu(window);
		               window.win.add(menu, BorderLayout.CENTER);
		               SwingUtilities.updateComponentTreeUI(window);
		            }
		         }
		      );
	}

}
