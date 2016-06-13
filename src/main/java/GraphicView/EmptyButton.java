package GraphicView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Model.CellStrategy;
import it.unimi.di.sweng.lasergame.Direction;
import it.unimi.di.sweng.lasergame.Laser;

public class EmptyButton extends ButtonStrategy {
	boolean images=true;
	
	public EmptyButton(int i,CellStrategy cs){//il numero passato sarà un identificatore univoco all'interno della griglia
		
		super(i,"",cs);
		
		
	}
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

    	if(temp.getLaser().size()!=0){
        	Graphics2D g2 = (Graphics2D)g.create();
        	if(images){
	    		ArrayList<Laser> ls = temp.getLaser();
	    		ImageDemon id = ImageDemon.getImageDemon();
	    		for(Laser x: ls){
	    			switch(x.getDir()){
						case Direction.UP:
						case Direction.DOWN:
							g2.drawImage(id.getY(), 0, 0, getWidth(), getHeight(),null);
							break;
						case Direction.LEFT:
						case Direction.RIGHT:
							g2.drawImage(id.getX(), 0, 0, getWidth(), getHeight(),null);						
	    			}
	    		}
        	}
        	else{
        		ArrayList<Laser> ls = temp.getLaser();
        		for(Laser x: ls){
        			g2.setColor(Color.red);
	    			switch(x.getDir()){
						case Direction.UP:
						case Direction.DOWN:
							g2.drawLine(getWidth()/2,0,getWidth()/2,getHeight() );
							break;
						case Direction.LEFT:
						case Direction.RIGHT:
							g2.drawLine(0,getHeight()/2,getWidth(),getHeight()/2 );						
	    			}
        		}
        	}
        	
    	}
    	g.dispose();
	}
}
