package all;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	public static String DIRETORIO = Music.class.getResource(".").getPath();
	
	public Music() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Clip clip;
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(DIRETORIO+"music.wav").getAbsoluteFile());
		clip = AudioSystem.getClip();
		clip.open(audioInputStream); 
		clip.loop(5);
		clip.start();
	}
}
