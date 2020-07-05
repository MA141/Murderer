package all;

public class Initial implements IInitial {
	int[][] initialPositions;
	int[][] ini = {{0,0},{11,11},{20,20},{20,20},{20,20},{20,20}};
	Initial(){
		this.initialPositions = ini;
	}
	public int[][] getInitialPositions() {
		return initialPositions;
	}
}
