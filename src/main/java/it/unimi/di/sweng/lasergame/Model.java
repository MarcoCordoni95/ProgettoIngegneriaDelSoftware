package it.unimi.di.sweng.lasergame;

import java.util.Observable;

public class Model extends Observable {
	private Laser laser;
	private CellStrategy[][] board={{null, null, null, null, null},
									{null, null, null, null, null},
									{null, null, null, null, null},
									{null, null, null, null, null},
									{null, null, null, null, null}
									};
	private int count;		//contatore delle mosse
						
	
	
	public Model (Laser laser){
		RandomCells random = new RandomCells();
		board= random.filler(board);
		count=0;
		this.laser=laser;
		
	} 
	
	public int getCount(){
		return this.count;
	}
	
	public void updateModel (int x, int y, int x1, int y1){	//i parametri sono le coordinate della posizione
			board[x1][y1] = board[x][y];
			board[x][y] = new EmptyCell();		//spostato banalmente l'oggetto
			
			count++;
	
		//	laser.CALCOLOLASER(board);  ancora non so cosa ritorna o cosa fa
			
			notifyObservers(); 	//passo alla view tutto quello che contiene il model , gli passo l'oggetto osservato, ma non sono sicura di quello che fa () o (this), sulle api non è specificato 
			
	}
}
