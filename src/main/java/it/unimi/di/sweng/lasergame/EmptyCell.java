package it.unimi.di.sweng.lasergame;

public class EmptyCell extends CellStrategy {
		/*nothing to do*/
	private Laser l=null;
	
	public void setLaser(Laser l){
		this.l = l;
	}
	
	public boolean issetLaser(){
		if(l!=null) return true;
		else return false;
	}
	
	public Laser getLaser(){
		return l;
	}
	
	public void action(Laser laser){};
}
