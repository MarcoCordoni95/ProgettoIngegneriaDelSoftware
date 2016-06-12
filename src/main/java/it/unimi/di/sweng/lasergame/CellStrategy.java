package it.unimi.di.sweng.lasergame;

import java.util.ArrayList;

public abstract class CellStrategy {
	ArrayList<Laser> laser  = new ArrayList<Laser>();
	public abstract void action(Laser laser);
	
	public void setLaser(Laser l){
		laser.add(l);
	};
	
	public ArrayList<Laser> getLaser(){
		return laser;
	};
	
	/*
	 *  da richiamare ogni volta che qualcosa cambia nella board
	 */
	public void purgeLaser(){
		laser=new ArrayList<Laser>();
	}
	
}