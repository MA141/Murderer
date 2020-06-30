package all;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIGrid extends JPanel implements ActionListener{ //Nao tenho certeza se realmetne deve implementar ActionListener
	private static final long serialVersionUID = 3521756621392929425L;
	public static String DIRETORIO = GUIGrid.class.getResource(".").getPath();
	
	Window window;
	Board board; //Classe Board do jogo final;
	int[] ocupadas = new int[6];
	
	public GUIGrid(Window window) {
		super(new GridLayout(12,12));
		this.window=window;
		this.board=window.hunter.board;
		draw();
	}
	
	public int[] converte() {
		for (int i=0; i<6; i++) {
			ocupadas[i]=(12*(board[i][0])+(board[i][1]));
		}
	}
	
	void draw() {
		ImageIcon sqr = new ImageIcon(DIRETORIO+"square.png"); //Preciso adicionar as imagens ainda.
		ImageIcon hunter = new ImageIcon(DIRETORIO+"hunter.png");
		ImageIcon surv = new ImageIcon(DIRETORIO+"survivor.png");
		ImageIcon rad1 = new ImageIcon(DIRETORIO+"rad1.png");
		ImageIcon rad2 = new ImageIcon(DIRETORIO+"rad2.png");
		ImageIcon rad3 = new ImageIcon(DIRETORIO+"rad3.png");
		ImageIcon gun = new ImageIcon(DIRETORIO+"gun.png");
		
		
		for(int j=0; j<143; j++) { 
			switch (j) { 
			case ocupadas[0]:
				this.add(new JLabel(hunter));
				break;
			case ocupadas[1]:
				this.add(new JLabel(surv));
				break;
			case ocupadas[2]:
				this.add(new JLabel(rad1));
				break;
			case ocupadas[3]:
				this.add(new JLabel(rad2));
				break;
			case ocupadas[4]:
				this.add(new JLabel(rad3));
				break;
			case ocupadas[5]:
				this.add(new JLabel(gun));
				break;
			default:
				this.add(new JLabel(sqr));
			}
				
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}