package it.unimi.di.sweng.lasergame;

public class Direction {
	
	public static final int UP=1;
	public static final int RIGHT=3;
	public static final int DOWN=2;
	public static final int LEFT=4;
	
	private Direction(){}
	
	public static int flip(int i){
		if(i%2==0)
			return --i;
		else
			return ++i;
	}
}
