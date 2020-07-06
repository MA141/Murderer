package all;

import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class Handler implements ActionListener {
	JButton start, stop, speed, slow;
	GUIGrid tab;
	Window window;
	Container win;
	IResult result;
	public static int i=0;
	GUIControl cont;
	ITable table;
	int[][] pos;
	IPieceDynamic murderer, survivor;

	public Handler (ITable table, GUIControl cont) {
		this.tab=table.getGrid();
		this.window=table.getWindow();
		win=window.getWin();
		pos=window.getPositions();
		this.cont=cont;
		this.survivor=window.getSurvivor();
		this.murderer=window.getMurderer();
		result = new State(pos);
	}	
	public void actionPerformed(ActionEvent evento) {
		tab.removeAll();
		
		murderer.move();
		if(result.getResult()==1) { //murderer ganhou
			win.removeAll();
			cont.metro.stop();
			GUIGameOver go= new GUIGameOver(cont, 1);
			win.add(go, BorderLayout.CENTER);
			SwingUtilities.updateComponentTreeUI(win);
		}
		survivor.move();
		if(result.getResult()==2)  { //survivor ganhou
			win.removeAll();
			cont.metro.stop();
			GUIGameOver go= new GUIGameOver(cont, 2);
			win.add(go, BorderLayout.CENTER);
			SwingUtilities.updateComponentTreeUI(win);
		}
		tab.draw();
		SwingUtilities.updateComponentTreeUI(tab);
	}
}