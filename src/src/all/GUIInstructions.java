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

public class GUIInstructions extends JPanel{
	private static final long serialVersionUID = 8526218078200426878L;
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	ImageIcon inst = new ImageIcon(DIRETORIO +"MenuImages\\"+ "instructions4.png");
	ImageIcon menu = new ImageIcon(DIRETORIO +"MenuImages\\"+ "menu.png");
	JButton back = new JButton(menu); 
	Window window;
	
	public GUIInstructions(Window window) {
		super();
		this.window=window;
		setSize(620, 680);
		this.setLayout(null);
		JLabel img=new JLabel(inst);
		
		Insets insets = this.getInsets();
		Dimension size = img.getPreferredSize();
		size = back.getPreferredSize();
		back.setBounds(25 + insets.left,170+ insets.top, 130, 30);
		this.add(back);
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
