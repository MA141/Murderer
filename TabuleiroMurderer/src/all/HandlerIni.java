package all;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class HandlerIni implements ActionListener{
	JTextField jtf;
	String text2 =new String("Escolha a coordenada da segunda peça do rádio");
	String text3 =new String("Escolha a coordenada da terceira peça do rádio");
	String text4 =new String("Escolha a coordenada da arma");
	Window window;
	Container win;
	GUIGrid tab;
	public static int i=0;
	
	public HandlerIni(JTextField jtf, GUIGrid tab, Window window) {
		this.tab=tab;
		this.window=window;
		this.win=window.win;
		this.jtf=jtf;
	}
	
	public void actionPerformed(ActionEvent evento) {
		tab.removeAll();
		String command=jtf.getText(); 
		//usa o try-catch, se houver erro, pede para repetir
		
		//Converte command para coordenada da matriz
		//window.hunter.board.positions[i+2]=position; //position eh a string command convertida para o formato int[]
		
		if (i<3) {
			GUIFlowText novo = new GUIFlowText(tab,window, "DUMMY");
			switch (i) {
			case 0:
				novo = new GUIFlowText(tab, window, text2);
				break;
			case 1:
				novo = new GUIFlowText(tab, window, text3);
				break;
			case 2:
				novo = new GUIFlowText(tab, window, text4);
				break;
			}
			win.remove(win.getComponent(1));
			i++;
			win.add(novo, BorderLayout.SOUTH);	
		}
		else {
			GUIControl controles = new GUIControl(tab, window);
			win.getComponent(1).setVisible(false);
			win.remove(win.getComponent(1));
			win.add(controles, BorderLayout.SOUTH);
		}
		tab.draw();
		SwingUtilities.updateComponentTreeUI(tab);
		
	}
		
}
