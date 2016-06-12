package it.unimi.di.sweng.lasergame;

public class Laser{
	private int direction;
	private boolean win;
	
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

}
