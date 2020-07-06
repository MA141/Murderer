package all;

import java.awt.Container;

public interface IWindow {
	public Murderer getMurderer();
	public Survivor getSurvivor();
	public int[][] getPositions();
	public Container getWin();
	public void create();
	public Music getMusic();
}
