//Se apertar start-> inicia o timer;
//Se apertar stop-> para o timer;
//Se apertar speed-> diminui o intervalo do timer
//Se apertar slow-> aumenta o intervalo do timer
//Se o timer ativar-> Chama o PieceDyn.move(), depois chama o PieceDyn.tabuleiro.move(); //Talvez seja melhor criar variaveis aqui para controlar mais facil
//
//
//

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
	public static int i=0;
	
	public Handler (GUIGrid tab, Window window) {
		this.tab=tab;
		this.window=window;
		//this.win=window.win;
	}
		
	public void actionPerformed(ActionEvent evento) {
		tab.removeAll();
		//Move os personagens a cada passagem do timer
		int[] movHunt =window.hunter.move();
		int[] movSurv =window.survivor.move();
		window.hunter.board.move(movHunt);
		window.survivor.board.move(movSurv); //Acho que seria necessario passar a posicao inicial tambem..
		tab.draw();
		
		SwingUtilities.updateComponentTreeUI(tab);
	}
}