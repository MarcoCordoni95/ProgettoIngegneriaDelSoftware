package it.unimi.di.sweng.lasergame;

import java.util.ArrayList;

import javax.swing.JComponent;

public class Cell {

	JComponent drawArea=null;
	Block blocco=null;
	ArrayList<Laser> laser=null;
	Mirror specchio=null;
	boolean flgTarget=false;

	public Cell(CellDrawStrategy s){
		laser=new ArrayList<Laser>();
	}
	
	public Mirror getMirror(){
		return specchio;
	}
	public void setMirror(Mirror m){
		specchio=m;
	}
	public void setLaser(Laser l){
		laser.add(l);
	}
	public ArrayList<Laser> getLaser(){
		return laser;
	}
	public void purgeLaser(){
		laser=new ArrayList<Laser>();;
	}
	public void setBlock(Block b){
		blocco=b;
	}
	
	public void setTarget(boolean b){
		flgTarget=b;
	}
		
	
}
