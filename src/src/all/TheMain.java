package all;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TheMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		
		IInitial initial = new Initial();
		IPieceStatic gun = new Gun();	gun.setAmount(0);
		IPieceStatic radio = new Radio();	radio.setAmount(0);
		IPieceDynamic murderer = new Murderer(initial.getInitialPositions());
		IPieceDynamic survivor = new Survivor(initial.getInitialPositions(), murderer, gun, radio);
		Window window = new Window(initial.getInitialPositions(),murderer,survivor);
		

	}

}
