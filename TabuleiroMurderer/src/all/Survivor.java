package all;

public class Survivor extends PieceDynamic {
	IPieceDynamic murderer;
	IPieceStatic gun;
	IPieceStatic radio;
	int vision=3;//range de squares que o survivor vê
	Survivor(int[][] positions,IPieceDynamic murderer, IPieceStatic gun, IPieceStatic radio){
		super(positions);
		this.murderer = murderer;
		this.gun = gun;
		this.radio = radio;		
	}
	public void move() {
		
		if((Math.abs(positions[0][0]-positions[1][0])<=vision) && (Math.abs(positions[0][1]-positions[1][1])<=vision)){// se esta proximo do murderer
			if(gun.getAmount()>0) {
				//murderer.hit=true;
				gun.setAmount(gun.getAmount()-1);
				if(gun.getAmount()==0)positions[5][1]=0;
			}
			if(positions[0][0]>=positions[1][0] && positions[1][0]>0) positions[1][0]--;
			if(positions[0][0]<=positions[1][0] && positions[1][0]<11) positions[1][0]++;
			if(positions[0][1]>=positions[1][1] && positions[1][1]>0) positions[1][1]--;
			if(positions[0][1]<=positions[1][1] && positions[1][1]<11) positions[1][1]++;
			return;
		}
		if(Math.abs(positions[1][0]-positions[2][0])<=1 && Math.abs(positions[1][1]-positions[2][1])<=1){//sobrevivente achou a primeira peça do radio
			positions[1][0]=positions[2][0]; positions[1][1]=positions[2][1];
			positions[2][0]=20; positions[2][1]=20;
			radio.setAmount(radio.getAmount()+1);
			return;
		}
		if(Math.abs(positions[1][0]-positions[3][0])<=1 && Math.abs(positions[1][1]-positions[3][1])<=1){//sobrevivente achou a segunda peça do radio
			positions[1][0]=positions[3][0]; positions[1][1]=positions[3][1];
			positions[3][0]=20; positions[3][1]=20;
			radio.setAmount(radio.getAmount()+1);
			return;
		}
		if(Math.abs(positions[1][0]-positions[4][0])<=1 && Math.abs(positions[1][1]-positions[4][1])<=1){//sobrevivente achou a terceira peça do radio
			positions[1][0]=positions[4][0]; positions[1][1]=positions[4][1];
			positions[4][0]=20; positions[4][1]=20;
			radio.setAmount(radio.getAmount()+1);
			return;
		}
		if(Math.abs(positions[1][0]-positions[5][0])<=1 && Math.abs(positions[1][1]-positions[5][1])<=1){//sobrevivente achou a arma
			positions[1][0]=positions[5][0]; positions[1][1]=positions[5][1];
			positions[5][0]=20; positions[5][1]=20;
			gun.setAmount(20);//mudar
			return;
		}
		else {
			if(rand.nextBoolean()) {//decide se vai andar para cima ou para baixo(ou se vai ficar parado)
				positions[1][0]+= rand.nextInt(2); 
				if(positions[1][0]>11) positions[1][0]-=2;//se ele estiver na borda ele vai pro outro lado
			}
			else {
				positions[1][0]-= rand.nextInt(2);
				if(positions[1][0]<0) positions[1][0]+=2;
			}
			if(rand.nextBoolean()){//decide se vai andar para esquerda ou para direita
				positions[1][1]+= rand.nextInt(2);
				if(positions[1][1]>11) positions[1][1]-=2;
			}
			else {
				positions[1][1]-= rand.nextInt(2);
				if(positions[1][1]<0) positions[1][1]+=2;
			}
			return;
		}
	}
	
}
