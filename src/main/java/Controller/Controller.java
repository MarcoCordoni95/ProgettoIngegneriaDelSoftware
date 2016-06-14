package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GraphicView.ButtonStrategy;
import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import Model.Model;
import it.unimi.di.sweng.lasergame.ViewInterface;

public class Controller implements ActionListener {

	int c=0, x, x1, y1, y;
	protected CellStrategy[][] board;
	
	protected Model model;
	protected ViewInterface view;
	
	
	public Controller(Model m, ViewInterface v) {
		model=m;
		view=v;
		board=m.getBoard();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		c++;
		ButtonStrategy butt= (ButtonStrategy) e.getSource();
		
		if(c==1){	
			int n=Integer.parseInt(butt.getName());
			x=n/5;					//x=riga
			y=n%5;					//y=colonna
			if (!(board[x][y] instanceof MirrorCell))
				c=0;				//controllo che la cella cliccata NON è uno specchio, inizializzo i clic
		}	
	
	
		if (c==2){					//questo controllo mi serve per vedere se è il secondo click, quello che determinerà la posizione
			int n=Integer.parseInt(butt.getName());
			x1=n/5;					
			y1=n%5;					
			
			if (x==x1 && y==y1)						//controllo se al secondo click è stato premuto nella stessa casella, quindi si vuole cambiare l'orientamento
				move(x, y, x1, y1);		

			if (board[x1][y1] instanceof EmptyCell){		//controllo che il sencondo click è su una empty cell in modo tale da non sovrascrivere specchi
				c=0;
				move(x, y, x1, y1);														
			}
			c=0;		//qualcosa non quadra, resettati i click
		}	
	}
		

	public void move(int x, int y, int x1, int y1){
			model.updateModel(x, y, x1, y1);
		}
}
