package it.unimi.di.sweng.lasergame;

import java.util.ArrayList;

import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import Model.TargetCell;

public class Laser {
	private int direction;
	private boolean win;

	//
	private int x = 0, y = 4;
	private int score;
	//
	public int getScore(){
		return this.score;
	}
	
	public Laser(){
		this.direction = 1; //UP
		this.win= false;
	}

	public Laser(int dir) {
		this.direction = dir;
		this.win = false;
	}

	public int getDir() {
		return direction;
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

	private void setLaser(CellStrategy c) {
		if (!c.isSetLaserList()) {
			c.setLaser(this);
		}
	}

	private void changeDirection(MirrorCell c) {
		c.action(this);
	}

	private int[] changeCoordinates(int x, int y) {
		int dir = getDir();
		switch (dir) {
		case 0: // UP
			x = (x - 1) % 5;
			break;
		case 1: // RIGHT
			y = (y + 1) % 5;
			break;
		case 2: // DOWN
			x = (x + 1) % 5;
			break;
		case 3: // LEFT
			y = (y - 1) % 5;
			break;
		}
		return new int[] { x, y };
	}

	/*
	 * SPECIFICHE PER METODO: TargetCell -> Traguardo EmptyCell -> cella vuota
	 * MirrorCell -> Specchio, in base al suo orientamento laser si muove
	 */
	public CellStrategy[][] getPercorso(CellStrategy[][] cs) {
		int[] xy = { 4, 0 };
		while (!getWin()) {
			// Traguardo
			if (cs[xy[0]][xy[1]] instanceof TargetCell) {
				setLaser((TargetCell) cs[xy[0]][xy[1]]);
				setWin();
				break;
			}
			// Cella vuota
			else if (cs[xy[0]][xy[1]] instanceof EmptyCell) {
				setLaser((EmptyCell) cs[xy[0]][xy[1]]);
			}
			// Specchio
			else if (cs[xy[0]][xy[1]] instanceof MirrorCell) {
				setLaser((MirrorCell) cs[xy[0]][xy[1]]);
			}
			xy = changeCoordinates(xy[0], xy[1]);
		}
		return cs;
	}

	// ######################à
	public CellStrategy[] newGetPercorso(CellStrategy[][] board) {
		ArrayList<CellStrategy> journey=new ArrayList <CellStrategy>();
		while (x >=0 && x<=4 && y>=0 && y<=4 && !win){
			journey.add(board[x][y]);
			board[x][y].action(this);
			board[x][y].setLaser(this);
			
			if(!win){	//se hai vinto di sicuro non ti metti a modificare cose, quindi fermati dopo aver aggiunto l'ultimo elemento
			switch (this.direction) {	//viene settata la posisione successiva 
				case 1:
					x--; // la x di laser va verso l'alto
					break;
				case 2:
					x++; // la x di laser va verso il basso
					break;
				case 3:
					y++; // la y di laser va verso destra
					break;
				case 4:
					y--; // la y di laser va verso sinistra					
					break;
				default:
					return null;
				}//END SWITCH
			}//END IF
		}//END WHILE 
		if(x<0 || x>4 || y>4 || y<0){
			switch(this.direction){	//qui ripristino la coordinata che va fuori
				case 1: x++; break; 
				case 2: x--; break; 
				case 3: y--; break; 
				case 4: y++; break; 		
			}
		}
		
		CellStrategy [] p={null};
		this.score=journey.size();
		x=4; y=0;	//ripristino le coordinate iniziali per fargli rifare il ciclo
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
