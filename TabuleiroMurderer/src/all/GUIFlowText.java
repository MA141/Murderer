package all;

import java.awt.FlowLayout;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIFlowText extends JPanel{
	private static final long serialVersionUID = -2205561324358798479L;
	GUIGrid tab;
	HandlerIni handlerIni;
	Container win;
	Window window;
	
	public GUIFlowText(GUIGrid tab, Window window, String text) {
		super(new FlowLayout());
		this.tab = tab;
		this.window=window;
		this.win = window.win;
		JTextField jtf= new JTextField(text, 50); //Talvez tenha problema com o texto padrao, entao pode ser que precise dar um setText.
		
		handlerIni = new HandlerIni(jtf, tab, window);
		jtf.addActionListener(handlerIni); 		this.add(jtf);
	}
	
	
}