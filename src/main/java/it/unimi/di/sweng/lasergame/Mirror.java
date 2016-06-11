package it.unimi.di.sweng.lasergame;

public class Mirror {
	int direction; //1 -> destra ( / ) , 3 sinistra (\) 
	
	public void setDirection(int d){
		direction=d;
	}
	public int getDirection(){
		return direction;
	}
}
