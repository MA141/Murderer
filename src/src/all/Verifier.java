package all;

public class Verifier {
    
    public static boolean isNum(String a){
        int b = Integer.parseInt(a);
        if (b>=0 & b<12) return true; 
        else return false;
    }
    
    public static boolean verifSize(String pos){
        //Verifica se o tamanho da string eh menor que 5;
        if (pos.length()>5) return false;
        return true;
    }
    
    public static boolean isFree(int[] st, int[][] taken){
        for (int i=0; i<6; i++){
            if (taken[i][0]==st[0] & taken[i][1]==st[1]){
                return false;
            }
        }
        return true;
    }
    
    public static int[] verif(String pos, int[][] taken)  throws InvalidInput{
        int[] ret = new int[2];
        if (verifSize(pos)==false){
            throw new InvStrSize("Invalid input, please insert the position again.");
        }
        
        
        String[] sp= pos.split(",", 2);
        if (sp.length<2) throw new InvStrSize("Invalid input, please insert the position again.");
        if (isNum(sp[0])==false || isNum(sp[1])==false){
            throw new InvStrCharacter("The characters you typed are not valid, please insert the position again.");
        }
        else {
            ret[0] = Integer.parseInt(sp[0]);
            ret[1] = Integer.parseInt(sp[1]);
        }
        
        if(isFree(ret, taken)==false){
            throw new InvPiecePosition("This position is already in use, please insert the position again.");
        }
        
        
        return ret;
    }
    
}

