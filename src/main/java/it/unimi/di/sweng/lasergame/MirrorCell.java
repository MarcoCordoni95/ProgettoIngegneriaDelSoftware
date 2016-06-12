package it.unimi.di.sweng.lasergame;

public class MirrorCell extends CellStrategy {
	private int orientation;	//per ora pensavo di fare, 0 / e 1 \ (ovviamente gli slash sono gli specchi)
	private Laser l = null;
	public MirrorCell (int i){
		this.orientation=i;
	}
	
	public Laser getLaser(){
		return l;
	}
	
	public void setLaser(Laser l){
		this.l = l;
	}
	
	public boolean issetLaser(){
		if(l!=null) return true;
		else return false;
	}
	 
	/*
	 * QUANDO VERRANNO SPOSTATI GLI SPECCHI C'E' BISOGNO DI UN METODO CHE RESETTA IL LASER A FALSE.
 	 * 
	 */
	
	@Override
	public void action (Laser laser){	
		int x;
		x = laser.getDir();
		if (orientation == 1) 		// l'orientamento = \
			switch (x){ 
			case 1: laser.setDir(4);
				break;				//1= su, 2= giu, 3= destra, 4= sinistra
			case 2: laser.setDir(3);
				break;
			case 3: laser.setDir(2);
				break;
			case 4: laser.setDir(1);	
				break;
			default:; 
			}
		
		if (orientation == 0)		//l'orientamento specchio = /
			switch (x){ 
			case 1: laser.setDir(3);
				break;
			case 2: laser.setDir(4);
				break;
			case 3: laser.setDir(1);
				break;
			case 4: laser.setDir(2);
				break;
			default:;
			}
	}
	
	

}
