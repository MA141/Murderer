package all;

public class Murderer extends PieceDynamic implements IPieceDynamic {
	int speed = 1;
	boolean hit = false;
	boolean awareness = false;
	
	Murderer(int[][] positions){
		super(positions);	
	}

	public void move() {
		if(hit){//esta baleado, nao se move
			hit=false;
			return;
		}
		if(awareness) {
			for(int i=1;i<=speed;i++) {
				if(positions[1][0]>positions[0][0]) positions[0][0]++;
				if(positions[1][0]<positions[0][0]) positions[0][0]--;
				if(positions[1][1]>positions[0][1]) positions[0][1]++;
				if(positions[1][1]<positions[0][1]) positions[0][1]--;
			}
			awareness = false;
			return;
		}
		else {
			for(int i=0;i<=speed;i++) {
				if(Math.abs(positions[1][0]-positions[0][0])<=1 && Math.abs(positions[1][1]-positions[0][1])<=1) {//cacador achou o sobrevivente
					positions[0][0]=positions[1][0]; positions[0][1]=positions[1][1];
					return;
				}
				if(rand.nextBoolean()) {//decide se vai andar para cima ou para baixo(ou se vai ficar parado)
					positions[0][0]+= rand.nextInt(2); 
					if(positions[0][0]>11) positions[0][0]-=2;//se ele tiver na borda ele vai pro outro lado
				}
				else {
					positions[0][0]-= rand.nextInt(2);
					if(positions[0][0]<0) positions[0][0]+=2;
				}
				if(rand.nextBoolean()){//decide se vai andar para esquerda ou para direita
					positions[0][1]+= rand.nextInt(2);
					if(positions[0][1]>11) positions[0][1]-=2;
				}
				else {
					positions[0][1]-= rand.nextInt(2);
					if(positions[0][1]<0) positions[0][1]+=2;
				}
			}
			return;
		}
	}
}
