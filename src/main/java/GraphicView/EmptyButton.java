package GraphicView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Model.CellStrategy;
import it.unimi.di.sweng.lasergame.Direction;
import it.unimi.di.sweng.lasergame.Laser;

public class EmptyButton extends ButtonStrategy {
	
	public EmptyButton(int i,CellStrategy cs){//il numero passato sarà un identificatore univoco all'interno della griglia
		
		super(i,"",cs);
		
		
	}
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
		ImageDemon.getImageDemon().drawLaserOnly(this, g2);
    	g.dispose();
	}
}
