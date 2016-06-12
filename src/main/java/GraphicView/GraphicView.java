package GraphicView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import org.hamcrest.core.IsInstanceOf;

import it.unimi.di.sweng.lasergame.AbstractController;
import it.unimi.di.sweng.lasergame.CellStrategy;
import it.unimi.di.sweng.lasergame.EmptyCell;
import it.unimi.di.sweng.lasergame.Model;
import it.unimi.di.sweng.lasergame.ViewInterface;

public class GraphicView extends JFrame implements ViewInterface , Observer{
	
	private Model model;

	public GraphicView(Model m){
		super("Laser Game");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.model=m;
		
		JPanel buttonGrid=new JPanel(new GridLayout(5, 5));
		JPanel optionGrid=new JPanel(new BorderLayout());
		
		this.addButton(buttonGrid);
		
		
		
		
		
		
		this.add(optionGrid);
		this.add(buttonGrid);
		
		
		
		
		this.setSize(200, 200);
		this.setVisible(true);
	}

	private void addButton(JPanel buttonGrid) {
		CellStrategy[][] board=this.model.getBoard();
		int i=0;
		for(int r=0;r<5;r++)
			for (int c=0;c<5;c++){
				if(board[r][c] instanceof EmptyCell)
					buttonGrid.add(new EmptyButton(i++));
				
			}
		
		
	}

	@Override
	public void addListener(AbstractController contr) {
		this.addListener(contr);
		
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	

}
