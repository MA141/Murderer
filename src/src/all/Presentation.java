package all;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import javax.swing.SwingUtilities;
import java.awt.Container;

public class Presentation extends JLabel{
	private static final long serialVersionUID = -1630866186178790718L;
	public static String DIRETORIO = Presentation.class.getResource(".").getPath();
	String[] nums = {"0","1","2","3","4","5","6","7","8","9","10","11"};
	//Window window;
	Container win;
	
	public Presentation(Window window) throws InterruptedException{
		this.win=window.getWin();
		win.add(new JLabel(new ImageIcon(DIRETORIO+"title\\M"+nums[0]+".png")));
		SwingUtilities.updateComponentTreeUI(window);
		Thread.sleep(2000);
		win.removeAll();
		for(int i = 1; i<11;i++) {
			win.add(new JLabel(new ImageIcon(DIRETORIO+"title\\M"+nums[i]+".png")));
			SwingUtilities.updateComponentTreeUI(window);
			Thread.sleep(30);
			win.removeAll();
		}
		win.add(new JLabel(new ImageIcon(DIRETORIO+"title\\M"+nums[11]+".png")));
		SwingUtilities.updateComponentTreeUI(window);
		Thread.sleep(200);
		win.removeAll();
	
	}
}
