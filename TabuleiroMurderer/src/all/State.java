package all;

public class State implements ITime, IResult{
	int time;
	int result=0;//0 eh indefinido, 1 eh vitoria do murderer e 2 eh vitoria do survivor 
	int[][] positions;
	public State(int[][] positions){
		this.positions = positions;
	}
	public int getTime() {
		return time;
	}

	public int getResult() {
		if(positions[2][0]>13 && positions[3][0]>13 && positions[4][0]>13) result=2;
		if(positions[0][0]==positions[1][0] && positions[0][1]==positions[1][1]) result=1;
		return result;
	}

}
