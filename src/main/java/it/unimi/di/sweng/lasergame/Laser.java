package it.unimi.di.sweng.lasergame;

import Model.EmptyCell;
import Model.MirrorCell;
import Model.TargetCell;

public class Laser{
	private int direction;
	private boolean win;
	
	public Laser(){
		this.direction = 0; //UP
		this.win= false;
	}
	
	public Laser(int dir){
		this.direction =dir;
		this.win= false;
	}
	
	public int getDir(){
		return direction; 
	}
	
	public void setDir(int i){
		this.direction=i;
	}
	
	public void setWin(){
		this.win=true;
	}
	
	public boolean getWin(){
		return this.win;
	}
	

	private void setLaser(CellStrategy c){
		if(!c.isSetLaserList()){
			c.setLaser(this);
		}
	}
	
	
	
	private void changeDirection(MirrorCell c) {
		c.action(this);
	}

	private int[] changeCoordinates(int x,int y) {
		int dir = getDir();
		switch(dir){
			case 0: //UP
				x=(x-1)%5;
				break;
			case 1:	//RIGHT
				y=(y+1)%5;
				break;
			case 2: //DOWN
				x=(x+1)%5;
				break;
			case 3: //LEFT
				y=(y-1)%5;
				break;
		}
		return new int[] {x, y};
	}
	
	
	/* SPECIFICHE PER METODO:
	 * TargetCell -> Traguardo
	 * EmptyCell -> cella vuota
	 * MirrorCell -> Specchio, in base al suo orientamento laser si muove
	 */
	public CellStrategy[][] getPercorso(CellStrategy[][] cs){
		int[] xy={4,0};
		while(!getWin()){
			//Traguardo
			if(cs[xy[0]][xy[1]] instanceof TargetCell){
				setLaser((TargetCell) cs[xy[0]][xy[1]]);
				setWin();
				break;
			}
			//Cella vuota
			else if(cs[xy[0]][xy[1]] instanceof EmptyCell){
				setLaser((EmptyCell) cs[xy[0]][xy[1]]);
			}
			//Specchio
			else if(cs[xy[0]][xy[1]] instanceof MirrorCell){
				setLaser((MirrorCell)cs[xy[0]][xy[1]]);
			}
			xy=changeCoordinates(xy[0],xy[1]);
		}
		return cs;
	}

	

}
