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
	private int counter = 1;
	
	public Handler (GUIGrid tab, Window window) {
		this.tab=tab;
		this.window=window;
		result = new State(window.positions);
	}
		
	public void actionPerformed(ActionEvent evento) {
		tab.removeAll();
		if(counter % 70 == 0) window.murderer.speed++;//aumenta a velocidade do murderer depois de 70 rounds (testar valores)
		if(counter % 13 == 0) window.murderer.awareness = true;// faz com que o murderer veja o survivor a cada 13 rounds (testar valores)
		window.murderer.move();
		if(result.getResult()==1) {
			window.win.removeAll();
			SwingUtilities.updateComponentTreeUI(window.win);
		}
		window.survivor.move();
		if(result.getResult()==2)  {//survivor nunca ganha do jeito que ta, tenho que mudar um pouco a logica da move
			window.win.removeAll();
			SwingUtilities.updateComponentTreeUI(window.win);
		}
		tab.draw();
		counter ++;
		SwingUtilities.updateComponentTreeUI(tab);
	}
}