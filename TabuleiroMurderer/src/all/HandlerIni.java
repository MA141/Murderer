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
	String text2 =new String("Escolha as coordenadas da segunda peça do rádio");
	String text3 =new String("Escolha as coordenadas da terceira peça do rádio");
	String text4 =new String("Escolha as coordenadas da arma");
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
		String err = new String();
		boolean failed=false;
		int[] st = new int[2];
		GUIFlowText novoErro;
		try {
			st=Verifier.verif(command, window.positions);
			failed=false;
		} catch (InvStrSize erro){
		    err=erro.getMessage();
		    failed=true;
		    novoErro = new GUIFlowText(tab, window, err);
			win.remove(win.getComponent(1));
			win.add(novoErro, BorderLayout.SOUTH);	
			tab.draw();
			SwingUtilities.updateComponentTreeUI(tab);
		} catch (InvStrCharacter erro){
			err=erro.getMessage();
			failed=true;
			novoErro = new GUIFlowText(tab, window, err);
			win.remove(win.getComponent(1));
			win.add(novoErro, BorderLayout.SOUTH);
			tab.draw();
			SwingUtilities.updateComponentTreeUI(tab);
		} catch (InvPiecePosition erro){
			 err=erro.getMessage();
			 failed=true;
			 novoErro = new GUIFlowText(tab, window, err);
			win.remove(win.getComponent(1));
			win.add(novoErro, BorderLayout.SOUTH);	
			tab.draw();
			SwingUtilities.updateComponentTreeUI(tab);
		} catch (NumberFormatException erro){
		    err="String com caracteres invalidos, digite novamente";
		    failed=true;
		    novoErro = new GUIFlowText(tab, window, err);
			win.remove(win.getComponent(1));
			win.add(novoErro, BorderLayout.SOUTH);	
			tab.draw();
			SwingUtilities.updateComponentTreeUI(tab);
		} catch (InvalidInput erro) {
			 err=erro.getMessage();
			 failed=true;
			 novoErro = new GUIFlowText(tab, window, err);
			win.remove(win.getComponent(1));
			win.add(novoErro, BorderLayout.SOUTH);	
			tab.draw();
			SwingUtilities.updateComponentTreeUI(tab);
		}
		

		
		//Converte command para coordenada da matriz
		//window.hunter.board.positions[i+2]=position; //position eh a string command convertida para o formato int[]
		if (failed==false) {
			if (i<4) {
				GUIFlowText novo = new GUIFlowText(tab,window, "DUMMY");
				switch (i) {
				case 0:
					window.positions[2][0]=st[0];
					window.positions[2][1]=st[1];
					novo = new GUIFlowText(tab, window, text2);
					win.remove(win.getComponent(1));
					win.add(novo, BorderLayout.SOUTH);	
					break;
				case 1:
					window.positions[3][0]=st[0];
					window.positions[3][1]=st[1];
					novo = new GUIFlowText(tab, window, text3);
					win.remove(win.getComponent(1));
					win.add(novo, BorderLayout.SOUTH);
					break;
				case 2:
					window.positions[4][0]=st[0];
					window.positions[4][1]=st[1];
					novo = new GUIFlowText(tab, window, text4);
					win.remove(win.getComponent(1));
					win.add(novo, BorderLayout.SOUTH);
					break;
				case 3:
					window.positions[5][0]=st[0];
					window.positions[5][1]=st[1];
				}
				i++;
			}
			if(i>3) {
				GUIControl controles = new GUIControl(tab, window);
				win.getComponent(1).setVisible(false);
				win.remove(win.getComponent(1));
				win.add(controles, BorderLayout.SOUTH);
			}
			tab.draw();
			SwingUtilities.updateComponentTreeUI(tab);
		}
	}
		
}
