package Model;

import it.unimi.di.sweng.lasergame.CellStrategy;
import it.unimi.di.sweng.lasergame.Laser;

public class MirrorCell extends CellStrategy {
	private int orientation;	//per ora pensavo di fare, 0 / e 1 \ (ovviamente gli slash sono gli specchi)
	
	public MirrorCell (int i){
		this.orientation=i;
	}
	
	public int getOrientation(){
		return this.orientation;
	}
	
	public void setOrientation(){
		if (this.orientation==1)
			this.orientation=0;
		
		if (this.orientation==0)
			this.orientation=1;
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
	

	public void setOrientation(int o){
		orientation=o;
	}
}
