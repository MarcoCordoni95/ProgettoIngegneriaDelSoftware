package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import it.unimi.di.sweng.lasergame.Laser;
import it.unimi.di.sweng.lasergame.Laser.Support;

public class Model extends Observable {
	private Laser laser;
	private CellStrategy[][] board={{null, null, null, null, null},
									{null, null, null, null, null},
									{null, null, null, null, null},
									{null, null, null, null, null},
									{null, null, null, null, null}
									};
	private int count;		//contatore delle mosse
	Support[] colorTrack;
	
	
	public Model (Laser laser){
		RandomCells random = new RandomCells();
		board= random.filler(board);
		count=0;
		this.laser=laser;
		
	} 
	
	public int getCount(){
		return this.count;
	}
	
	public CellStrategy[][] getBoard(){
		return this.board;
	}
	
	public void updateModel (int x, int y, int x1, int y1){	//i parametri sono le coordinate della posizione
			if (x==x1 && y==y1)
				((MirrorCell)board[x][y]).setOrientation(); //casto l'oggetto perchè a questo punto sono mooooolto sicura che l'oggetto è di tipo mirrorCEll, nel controller c'è il controllo apposta
			
			else{
				board[x1][y1] = board[x][y];
				board[x][y] = new EmptyCell();		//spostato banalmente l'oggetto
			}
			count++;
			this.colorTrack=laser.newGetPercorso(board);
			this.setChanged();
			this.notifyObservers(); 	//passo alla view tutto quello che contiene il model , gli passo l'oggetto osservato, ma non sono sicura di quello che fa () o (this), sulle api non è specificato 
			
	}
	public Support[] getTrack(){
		return this.colorTrack;
		
	}
	public ArrayList<ArrayList<CellStrategy>> getTabel(){
		ArrayList<ArrayList<CellStrategy>> ret = new ArrayList<ArrayList<CellStrategy>>(); 
		for(int i=0; i<5; i++){
			ret.add((ArrayList) Arrays.asList(board));
		}
		return ret;
	}
}
