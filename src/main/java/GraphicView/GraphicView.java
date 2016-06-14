package GraphicView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Controller.Controller;
import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import Model.Model;
import it.unimi.di.sweng.lasergame.Laser;
import Model.TargetCell;
import it.unimi.di.sweng.lasergame.ScoreDisplay;
import it.unimi.di.sweng.lasergame.ShareScore;
import it.unimi.di.sweng.lasergame.ViewInterface;

public class GraphicView extends JFrame implements ViewInterface , Observer{
	
	private Model model;
	private Controller cont;
	private JPanel buttonGrid;
	private JPanel optionGrid;
	
	

	public GraphicView(Model m){
		super("Laser Game");
		Container co=this.getContentPane();
		co.setLayout(new BorderLayout());
		
		this.cont =new Controller(m, this);	//il controller per questa finestra lo creo all'interno della finestra stessa,
											//se mi dovesse servire lo posso ottenere tramite il metodo getController() qui in fondo
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.model=m;
		
	
		
		
		this.buttonGrid=new JPanel(new GridLayout(5, 5));
		this.optionGrid=new JPanel(new FlowLayout());
		
		this.addButton();
		//this.optionGrid.add(new JLabel("qui contatori vari"));
		
		this.addOption();
		
		
		
		
		
		co.add(optionGrid,BorderLayout.NORTH);
		co.add(buttonGrid,BorderLayout.CENTER);
	
		
		
		
		
	}
	
	private void addOption() {
		ShareScore score=new ShareScore();
		ScoreDisplay display=new ScoreDisplay(score);
		score.addObserver(display);
		
		JLabel scoreL=new JLabel("Score: ");
		JLabel nMoves=new JLabel("N°mosse "+this.model.getCount());
		
		this.optionGrid.setSize(200,100);
		
		
		this.optionGrid.add(scoreL);
		this.optionGrid.add(display);
		this.optionGrid.add(nMoves);
		
		
	}

	public void start(){
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
		ButtonStrategy b=null; 
		int i=0;
		String s=null;
		
		for(int r=0;r<5;r++)
			for (int c=0;c<5;c++){
				if(board[r][c] instanceof EmptyCell){
					b=new EmptyButton(i++,board[r][c] );
					b.addActionListener(this.cont);
					this.buttonGrid.add(b);
				}
				else if(board[r][c] instanceof MirrorCell){
					int x= ((MirrorCell)board[r][c]).getOrientation();
					if (x==0)
						s="/";
					if (x==1)
						s="\\";
						
					b=new MirrorButton(i++,s,board[r][c] );
					b.addActionListener(this.cont);

					this.buttonGrid.add(b);
					
				}
				else if(board[r][c] instanceof TargetCell){
					b=new TargetButton(i++,"target",board[r][c] );
					b.addActionListener(this.cont);
					this.buttonGrid.add(b);
					
				}
				
			}
		
		
	}



	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.buttonGrid.removeAll();
		this.optionGrid.removeAll();
		this.addButton();
		this.addOption();
		this.buttonGrid.revalidate();
		this.optionGrid.revalidate();
		this.buttonGrid.repaint();
		this.optionGrid.revalidate();
	}

	public Controller getController() {
		
		return this.cont;
	}
	

}
