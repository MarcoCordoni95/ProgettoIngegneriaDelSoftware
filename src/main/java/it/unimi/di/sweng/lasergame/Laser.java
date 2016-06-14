package it.unimi.di.sweng.lasergame;

import java.util.ArrayList;

import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import Model.TargetCell;

public class Laser {
	private int direction;
	private int fromDirection;
	private boolean win=false;

	//
	private int x = 4, y = 0;
	private int score;
	//
	
	
	public class Support{
		public int row;
		public int column;
		
		public Support(int x ,int y){
			this.row=x;
			this.column=y;
		}
		
	}
	
	public Laser(){
		this.direction = 1; //UP
		this.fromDirection=Direction.UP;
		this.win= false;
	}

	public Laser(int dir) {
		this.direction = dir;
		this.win = false;
	}
	public int getScore(){
		return this.score;
	}

	public int getDir() {
		return direction;
	}
	public int getFromDir(){
		return fromDirection;
	}
	public void setDir(int i) {
		this.direction = i;
	}

	public void setWin() {
		this.win = true;
	}

	public boolean getWin() {
		return this.win;
	}

	private Laser Lclone(){
		Laser ret = new Laser();
		ret.setDir(direction);
		ret.fromDirection=fromDirection;
		return ret;
	}
	
	private void setLaser(CellStrategy c) {
		if (!c.isSetLaserList()) {
			c.setLaser(this);
		}
	}

	
		public Support[] newGetPercorso(CellStrategy[][] board) {
		ArrayList<Support> journey=new ArrayList <Support>();
		int lastDir=this.direction;
		while (x >=0 && x<=4 && y>=0 && y<=4 && !win){
			journey.add(new Support(x, y));
			board[x][y].action(this);
			this.fromDirection=lastDir;
			board[x][y].setLaser(Lclone());		
			lastDir=this.direction;
			this.score++;
			if(!win){	//se hai vinto di sicuro non ti metti a modificare cose, quindi fermati dopo aver aggiunto l'ultimo elemento
			switch (this.direction) {	//viene settata la posisione successiva 
				case Direction.UP:
					x--; // la x di laser va verso l'alto
					break;
				case Direction.DOWN:
					x++; // la x di laser va verso il basso
					break;
				case Direction.RIGHT:
					y++; // la y di laser va verso destra
					break;
				case Direction.LEFT:
					y--; // la y di laser va verso sinistra					
					break;
				default:
					return null;
				}//END SWITCH
			}//END IF
		}//END WHILE 
		System.out.println("----");
		if(x<0 || x>4 || y>4 || y<0){
			switch(this.direction){	//qui ripristino la coordinata che va fuori
				case 1: x++; break; 
				case 2: x--; break; 
				case 3: y--; break; 
				case 4: y++; break; 		
			}
		}
		
		Support [] p={null};
		this.score=journey.size();
		x=4; y=0;	//ripristino le coordinate iniziali per fargli rifare il ciclo
		this.score=0;
		return journey.toArray(p); 	//ritorno la lista di celle percorse con in fondo un muro o un target
	}
	
	
	/*
	nel metodo io creo un arraylist di celle percorse da parte del laser, nel mentre aggiorno quel setLaser in ogni cella percorsa, 
	x, y ovviamente sono le coordinate del laser che questo assume ogni volta, quindi se è in posizione 0, 4, questo prenderà la cella 0,4
	la aggiungerà alla lista di celle percorse, poi in questa cella verrà chiamato setLaser, aggiorno la direzione che il laser prende nella casella
	corrente e infine restituisco il percorso che il laser ha fatto finora. 
	
	ho fatto prima l'assegnamento delle celle attuali, poi la posizione successiva in modo tale da segnare quella in cui sono, poi trovare la posizione successiva
	e controllae se questa è valida, se è valida il ciclo while prosegue
	*/
	
//##############################################
}
