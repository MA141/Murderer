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
	IResult result;
	public static int i=0;
	private static int counter = 1; //Nao tenho ctz que o counter eh static
	GUIControl cont;
	
	public Handler (GUIGrid tab, Window window, GUIControl cont) {
		this.tab=tab;
		this.window=window;
		this.cont=cont;
		result = new State(window.positions);
	}
	
	public void reset() {
		counter=1;
	}
		
	public void actionPerformed(ActionEvent evento) {
		tab.removeAll();
		if(counter % 70 == 0) window.murderer.speed++;//aumenta a velocidade do murderer depois de 70 rounds (testar valores)
		if(counter % 13 == 0) window.murderer.awareness = true;// faz com que o murderer veja o survivor a cada 13 rounds (testar valores)
		window.murderer.move();
		if(result.getResult()==1) { //murderer ganhou
			window.win.removeAll();
			cont.metro.stop();
			GUIGameOver go= new GUIGameOver(cont, 1);
			window.win.add(go, BorderLayout.CENTER);
			SwingUtilities.updateComponentTreeUI(window.win);
		}
		window.survivor.move();
		if(result.getResult()==2)  { //survivor ganhou
			window.win.removeAll();
			cont.metro.stop();
			GUIGameOver go= new GUIGameOver(cont, 2);
			window.win.add(go, BorderLayout.CENTER);
			SwingUtilities.updateComponentTreeUI(window.win);
		}
		tab.draw();
		counter ++;
		SwingUtilities.updateComponentTreeUI(tab);
	}
}