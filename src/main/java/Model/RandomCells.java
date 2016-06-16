package Model;
import java.util.Random;
public class RandomCells {
	private int nMirrors;
	private int nBlocks;
	
	
	
	public  CellStrategy[][]filler(CellStrategy[][] board){
		Random rand=new Random();
		boolean setTarget=false;
		
		this.nMirrors=rand.nextInt(13)+1;
		int r,c;
		for(int i=0;i<this.nMirrors;i++){
				r=rand.nextInt(5);
				c=rand.nextInt(5);
				if( board[r][c]==null){
					board[r][c]=new MirrorCell(rand.nextInt(2));
				}
		}

		while(!setTarget){
			if((r=rand.nextInt(5))!=4 &&(c=rand.nextInt(5))!=0){
				board[r][c]=new TargetCell();
				setTarget=true;
			}	
		}
		
		for(r=0;r<5;r++)
			for(c=0;c<5;c++){
				if (board[r][c]==null)
					board[r][c]=new EmptyCell();
			}
		return board;
	}
	
	public static  String randomMirror(){
		Random rand=new Random();
		int i=rand.nextInt(2);
		
		if (i==0)
			return "/";
		else if(i==1)
			return "\\";
			else
				return null;
	}
}
