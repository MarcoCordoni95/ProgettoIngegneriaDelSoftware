package GraphicView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Model.CellStrategy;
import Model.TargetCell;

public class TargetButton extends ButtonStrategy{
	
	public TargetButton(int i,String c,CellStrategy cs){//il numero passato sarà un identificatore univoco all'interno della griglia
		super(i,c,cs);
	}
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
		
		g2.setColor(Color.BLACK);
		g2.drawString("Target", getWidth()/2-20, getHeight()/2);
	}
	
	
}
