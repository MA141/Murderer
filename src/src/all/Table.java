package all;

public class Table implements ITable{
	private GUIGrid grid;
	private Window window;
	
	public void setWindow(Window window) {
		this.window=window;
	}
	
	public void setGrid(GUIGrid grid) {
		this.grid=grid;
	}
	
	public GUIGrid getGrid() {
		return grid;
	}
	
	public Window getWindow() {
		return window;
	}
}
