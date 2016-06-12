package GraphicView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import org.hamcrest.core.IsInstanceOf;

import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import Model.Model;
import Model.TargetCell;
import it.unimi.di.sweng.lasergame.AbstractController;
import it.unimi.di.sweng.lasergame.ViewInterface;

public class GraphicView extends JFrame implements ViewInterface , Observer{
	
	private Model model;
	private JPanel buttonGrid;
	private JPanel optionGrid;
	

	public GraphicView(Model m){
		super("Laser Game");
		Container co=this.getContentPane();
		co.setLayout(new BorderLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.model=m;
		
		this.buttonGrid=new JPanel(new GridLayout(5, 5));
		this.optionGrid=new JPanel(new BorderLayout());
		
		this.addButton();
		this.optionGrid.add(new JLabel("qui contatori vari"));
		
		
		
		
		
		
		co.add(optionGrid,BorderLayout.NORTH);
		co.add(buttonGrid,BorderLayout.CENTER);
	
		
		
		
		//this.setLookandFeel();
		this.setSize(500, 500);
		this.setVisible(true);
	}

	private void setLookandFeel() {
		
		try {
		    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, fall back to cross-platform
		    try {
		    	
		        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    } catch (Exception ex) {
		        // not worth my time
		    }
		}
		
	}

	private void addButton() {
		CellStrategy[][] board=this.model.getBoard();
		int i=0;
		
		for(int r=0;r<5;r++)
			for (int c=0;c<5;c++){
				if(board[r][c] instanceof EmptyCell)
					this.buttonGrid.add(new EmptyButton(i++));
				if(board[r][c] instanceof MirrorCell)
					this.buttonGrid.add(new MirrorButton(i++));
				if(board[r][c] instanceof TargetCell)
					this.buttonGrid.add(new TargetButton(i++));
				
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
