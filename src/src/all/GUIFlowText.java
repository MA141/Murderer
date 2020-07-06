package all;


import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIFlowText extends JPanel{
	private static final long serialVersionUID = -2205561324358798479L;
	GUIGrid tab;
	HandlerIni handlerIni;
	Container win;
	Window window;
	
	public GUIFlowText(ITable table, String text) {
		super(new BorderLayout());
		this.tab = table.getGrid();
		this.window=table.getWindow();
		this.win = window.getWin();
		JTextField jtf= new JTextField("", 80); 
		handlerIni = new HandlerIni(jtf, table);
		jtf.addActionListener(handlerIni); 		this.add(jtf, BorderLayout.SOUTH);
		this.add(new JLabel(text), BorderLayout.NORTH);
	}
	
	
}