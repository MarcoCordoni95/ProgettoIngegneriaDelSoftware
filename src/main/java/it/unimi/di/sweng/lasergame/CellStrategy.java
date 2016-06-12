package it.unimi.di.sweng.lasergame;

import java.util.ArrayList;

public abstract class CellStrategy {
	ArrayList<Laser> laserList  = new ArrayList<Laser>();
	public abstract void action(Laser laser);
	
	public void setLaser(Laser l){
		this.laserList.add(l);
	}
	
	public ArrayList<Laser> getLaser(){
		return this.laserList;
	}
	public boolean isSetLaserList(){
		if(this.laserList!=null) return true;
		else return false;
	}
	
	/*
	 *  da richiamare ogni volta che qualcosa cambia nella board
	 */
	public void purgeLaser(){
		this.laserList=new ArrayList<Laser>();
	}
	
}