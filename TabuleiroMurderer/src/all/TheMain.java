package all;

public class TheMain {

	public static void main(String[] args) {
		
		int[][] ini = {{0,0},{11,11},{20,20},{20,20},{20,20},{20,20}};
		Murderer murderer = new Murderer(ini);
		IPieceStatic gun = new Gun();	gun.setAmount(0);
		IPieceStatic radio = new Radio();	radio.setAmount(0);
		Survivor survivor = new Survivor(ini, murderer, gun, radio);
		Window window = new Window(ini,murderer,survivor);
		//IBoard board = new Board(ini);
		//murderer = new Murderer(board.getPos());

	}

}
