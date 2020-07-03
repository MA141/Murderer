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
	//Vai ter um botão que volta, e uma imagem lgl com as instruções.
	public static String DIRETORIO = Window.class.getResource(".").getPath();
	ImageIcon inst = new ImageIcon(DIRETORIO + "instructions.png");
	JButton back = new JButton("Return"); //Trocar por uma imagem.
	Window window;
	
	public GUIInstructions(Window window) {
		super();
		this.window=window;
		setSize(580, 470);
		this.setLayout(null);
		JLabel img=new JLabel(inst);
		this.add(img);
		this.add(back);
		Insets insets = this.getInsets();
		Dimension size = img.getPreferredSize();
		img.setBounds(insets.left,insets.top, size.width, size.height);
		size = back.getPreferredSize();
		img.setBounds(200 + insets.left,400 + insets.top, size.width, size.height);
		
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
