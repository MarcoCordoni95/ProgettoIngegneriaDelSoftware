package GraphicView;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;

import Model.CellStrategy;

public class MirrorButton extends ButtonStrategy {
	
	public MirrorButton(int i,String c,CellStrategy cs){//il numero passato sarà un identificatore univoco all'interno della griglia
		super(i,c,cs);
	}
	
	public MirrorButton change() {
		if(this.getWhoamI().equals("/"))
			return  new MirrorButton(this.getNumb(),"\\",cell);
		if(this.getWhoamI().equals("\\"))
			return  new MirrorButton(this.getNumb(),"/",cell);
		return null;
		
		
	}
	
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g.create();
        ImageDemon id = ImageDemon.getImageDemon();
        id.drawLaserOnly(this, g2);
        id.drawMirror(this, g2);
        g2.dispose();
        
	}	
}
