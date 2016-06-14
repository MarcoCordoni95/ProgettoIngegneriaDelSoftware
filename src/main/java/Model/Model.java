package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import javax.swing.JOptionPane;

import GraphicView.GraphicView;
import it.unimi.di.sweng.lasergame.Direction;
import it.unimi.di.sweng.lasergame.Laser;
import it.unimi.di.sweng.lasergame.Laser.Support;

public class Model extends Observable {
	private Laser laser;
	private boolean win=false, lose=false;
	private int difficulty, score;
	private CellStrategy[][] board=new CellStrategy[5][5];
	private int count;		//contatore delle mosse
	
	Support[] colorTrack;

	
	public Model (Laser laser){
		RandomCells random = new RandomCells();
		this.board= random.filler(board);
		this.count=0;
		this.laser=laser;
		this.laser.newGetPercorso(this.board);
		this.score=this.laser.getScore();	
	} 
	
	public void setNewBoard(){
		for (int r=0; r<5; r++)
			for (int c=0; c<5; c++)
				this.board[r][c]=null;
		RandomCells random = new RandomCells();
		this.board= random.filler(board);
		
		this.win=false;
		this.laser.setWin(false);
		this.count=0;
	}
	public void setDifficulty(int i){
		this.difficulty=i;
	}
	public int getCount(){
		return this.count;
	}
	public int getScore(){
		return this.score;
	}
	public void setBoard(CellStrategy[][] c ){
		board=c;
	}
	public CellStrategy[][] getBoard(){
		return this.board;
	}
	public boolean getLose(){
		return this.lose;
	}
	public boolean getWin(){
		return this.win;
	}
	
	
	
	public void updateModel (int x, int y, int x1, int y1){	//i parametri sono le coordinate della posizione
			if (x==x1 && y==y1)
				((MirrorCell)board[x][y]).setOrientation(); //casto l'oggetto perchè a questo punto sono mooooolto sicura che l'oggetto è di tipo mirrorCEll, nel controller c'è il controllo apposta
			else{
				board[x1][y1] = board[x][y];
				board[x][y] = new EmptyCell();		//spostato banalmente l'oggetto
			}
			count++;
			if (this.difficulty>0){//difficoltà avrà dei valori, da 1 a 5 per ora, 5 è lo score verrà 
				this.score*=difficulty;
				if(this.count > (10-difficulty)){	//10 è un numero pensato un po' a caso
					lose=true; 
				}
			}
			
			this.clearLaser();
			this.colorTrack=laser.newGetPercorso(board);
			this.win=this.laser.getWin();
			if(this.win){//controllo se ho vinto
				JOptionPane.showMessageDialog(null, "Contratulations.\n You have bested me this time");
				
				
			}
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
	public void clearLaser(){
		for(int i=0; i<5; i++){
			for(int j=0; j<5;j++){
				if(board[i][j].getLaser().size()>0){
					board[i][j].purgeLaser();
				}
			}
		}
		laser=new Laser();
	}
}