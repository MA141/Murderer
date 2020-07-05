package all;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIGrid extends JPanel implements ActionListener{
	private static final long serialVersionUID = 3521756621392929425L;
	public static String DIRETORIO = GUIGrid.class.getResource(".").getPath();
	
	ImageIcon[] images = new ImageIcon[144];
	Window window;;
	int[] ocupadas = new int[6];
	
	public GUIGrid(Window window) {
		super(new GridLayout(12,12));
		this.window=window;
		images=criaIm();
		draw();
	}
	
	public void converte() {
		for (int i=0; i<6; i++) {
			ocupadas[i]=(12*(window.positions[i][0])+(window.positions[i][1]));
		}
	}
	
	public ImageIcon randomIm() {
		ImageIcon ground;
		Random rand= new Random();
		int random= rand.nextInt(100);
		if (random<=30) ground = new ImageIcon(DIRETORIO+"Grounds\\"+"grass1.png");
		else if (random>30 & random<=60) ground = new ImageIcon(DIRETORIO+"Grounds\\"+"grass2.png");
		else if (random>60 & random<=80) ground = new ImageIcon(DIRETORIO+"Grounds\\"+"ground.png");
		else if (random>80 & random<=84) ground = new ImageIcon(DIRETORIO+"Grounds\\"+"groundDirt.png");
		else if (random>84 & random<=88) ground = new ImageIcon(DIRETORIO+"Grounds\\"+"grassRock.png");
		else if (random>88 & random<=90) ground = new ImageIcon(DIRETORIO+"Grounds\\"+"groundRock.png");
		else if (random>90 & random<=94) ground = new ImageIcon(DIRETORIO+"Grounds\\"+"stick.png");
		else if (random>94 & random<=97) ground = new ImageIcon(DIRETORIO+"Grounds\\"+"flower.png");
		else ground = new ImageIcon(DIRETORIO+"Grounds\\"+"root.png");
		return ground;
		
	}
	
	public ImageIcon[] criaIm() {
		for(int k=0; k<144; k++) {
			images[k]=randomIm();
		}
		return images;
	}
	
	
	
	void draw() {
		converte();
		ImageIcon sqr = new ImageIcon(DIRETORIO+"square.png");
		ImageIcon hunter = new ImageIcon(DIRETORIO+"murderer.png");
		ImageIcon surv = new ImageIcon(DIRETORIO+"survivor.png");
		if(window.positions[5][0]>12)surv = new ImageIcon(DIRETORIO+"survivorWgun.png");	
		ImageIcon rad1 = new ImageIcon(DIRETORIO+"rad1.png");
		ImageIcon rad2 = new ImageIcon(DIRETORIO+"rad2.png");
		ImageIcon rad3 = new ImageIcon(DIRETORIO+"rad3.png");
		ImageIcon gun = new ImageIcon(DIRETORIO+"gun.png");
		
		//Vetor Images de ImageIcon, no inicio faz um for int k=0; k<144; k++ e a cada passagem adiciona um randomIm() na posicao, na hora fazer o draw, adiciona o Images[j];
		
		for(int j=0; j<144; j++) { 
			if(j==ocupadas[0])this.add(new JLabel(hunter));
			else if(j==ocupadas[1])this.add(new JLabel(surv));
			else if(j==ocupadas[2])this.add(new JLabel(rad1));
			else if(j==ocupadas[3])this.add(new JLabel(rad2));
			else if(j==ocupadas[4])this.add(new JLabel(rad3));
			else if(j==ocupadas[5])this.add(new JLabel(gun));
			else {
				sqr=images[j];
				this.add(new JLabel(sqr));
			}
		}
				
	}
	@Override
	public void actionPerformed(ActionEvent e) {	
	}
}