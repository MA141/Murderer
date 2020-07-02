package all;

import java.util.Random;

public abstract class PieceDynamic implements IPieceDynamic {
	int[][] positions;
	Random rand;
	
	public PieceDynamic(int[][] positions) {
		this.positions = positions;
	}
	public void move() {

	}
}
