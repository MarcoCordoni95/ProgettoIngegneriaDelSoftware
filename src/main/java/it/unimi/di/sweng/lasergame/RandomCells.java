package it.unimi.di.sweng.lasergame;
import java.util.Random;
public class RandomCells {
	private int nMirrors;
	private int nBlocks;
	
	
	
	public  CellStrategy[][]  filler(CellStrategy[][] board){//passo la matrice delle celle che so essere 5x5
		Random rand=new Random();
		boolean setTarget=false;
		this.nMirrors=rand.nextInt(13)+1;// cosi il numero di specchi sarà >=1 && <=13
		 
		int r,c;
		for(int i=0;i<this.nMirrors;i++){//ciclo finche ho specchi da mettere
				r=rand.nextInt(5);
				c=rand.nextInt(5);
				if( board[r][c]==null){//se la cella selezionata è gia occupata non metto nulla e la condizione di <=13 è rispettata
					board[r][c]=new MirrorCell(rand.nextInt(2));//inserisco lo specchio con orientamento random	
				}
			
		}
		r=0; c=0;//reinizializzo gli indici della matrice
		
		while(!setTarget){// aggiungo il target 
			if((r=rand.nextInt(5))!=4 &&(c=rand.nextInt(5))!=0){
				board[r][c]=new TargetCell();
				setTarget=true;
			}	
		}
		
		
			
		
		
	}
}
