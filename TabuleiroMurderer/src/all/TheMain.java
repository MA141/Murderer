package all;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TheMain {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		int[][] ini = {{0,0},{11,11},{20,20},{20,20},{20,20},{20,20}};
		Murderer murderer = new Murderer(ini);
		IPieceStatic gun = new Gun();	gun.setAmount(0);
		IPieceStatic radio = new Radio();	radio.setAmount(0);
		Survivor survivor = new Survivor(ini, murderer, gun, radio);
		Window window = new Window(ini,murderer,survivor);
		

	}

}
