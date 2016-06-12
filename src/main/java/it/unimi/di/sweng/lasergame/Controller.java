package it.unimi.di.sweng.lasergame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	int c=0, x, x1, y1, y;
	CellStrategy[][] board;
	
	protected Model model;
	protected ViewInterface view;
	
	
	private Controller(Model m, ViewInterface v) {
		model=m;
		view=v;
		board=m.getBoard();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		c++;
	
		if(c==1){	
			int n=Integer.parseInt(e.getActionCommand());
			x=n/5;					//x=riga
			y=n%5;					//y=colonna
			if (!(board[x][y] instanceof MirrorCell))
				c=0;				//controllo che la cella cliccata NON è uno specchio, non mi serve azzerare i valori, dato che al prossimo avvio verranno reinizianizializzati
		}	
	
	
		if (c==2){					//questo controllo mi serve per vedere se è il secondo clic, quello che determinerà la posizione
			int n=Integer.parseInt(e.getActionCommand());
			x1=n/5;					//x=riga
			y1=n%5;					//y=colonna
			if (!(board[x][y] instanceof EmptyCell)){
				c=0;				//controllo che il sencondo clic è su una empty cell in modo tale da non sovrascrivere specchi
				x=y=x1=y1=0; 		//se il secondo clic non è su uno spazio accettabile, azzero il clicounter e i vari vaori
			}		
			move(x, y, x1, y1);		
		}	
	}
		

	public void move(int x, int y, int x1, int y1){
			model.updateModel(x, y, x1, y1);
		}
	
}
