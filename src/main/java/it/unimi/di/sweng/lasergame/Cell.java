package it.unimi.di.sweng.lasergame;

import javax.swing.JComponent;

public class Cell {

	JComponent drawArea=null;
	Block blocco=null;
	Laser laser=null;
	Mirror specchio=null;
	boolean flgTarget=false;
	CellDrawStrategy strategy;

	public Cell(CellDrawStrategy s){
		strategy=s;
	}
	
	public Mirror getMirror(){
		return specchio;
	}
	public void setMirror(Mirror m){
		specchio=m;
	}
	public void setLaser(Laser l){
		laser=l;
	}
	public void purgeLaser(){
		laser=null;
	}
	public void setBlock(Block b){
		blocco=b;
	}
	
	public void setTarget(boolean b){
		flgTarget=b;
	}
	
	
	
}
