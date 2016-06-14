package GraphicView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import it.unimi.di.sweng.lasergame.Direction;
import it.unimi.di.sweng.lasergame.Laser;
public class ImageDemon {
	
	Image laserX;
	Image laserY;
	Image mirror;
	
	public static ImageDemon ImgDem;
	final Color L_COLOR = Color.red; 
	
	private ImageDemon(){
		try {
			laserX = ImageIO.read(new File("./src/Res/lx.png/"));
			laserY = ImageIO.read(new File("./src/Res/ly.png/"));

			
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
		ImgDem=this;
	}
	
	public static ImageDemon getImageDemon(){
		if(ImgDem==null){
			new ImageDemon();
		}
		return ImgDem;
	}
	
		
	public void drawMirror(JButton b, int direction){
		
	}

	public Image getY(){
		return laserY;
	}
	
	public Image getX(){
		return laserX;
	}
	public void drawLaserOnly(ButtonStrategy b,Graphics2D g2){
		ArrayList<Laser> ls = b.getCell().getLaser();
		if(!b.getDrawOption()){
	    	for(Laser x: ls){
	    		int[] points = getDrawCoords(Direction.flip(x.getFromDir()),b);
	    		g2.setColor(L_COLOR);
	    		g2.drawLine(points[0], points[1], points[2], points[3]);
	    		points=getDrawCoords(x.getDir(),b);
	    		g2.drawLine(points[0], points[1], points[2], points[3]);
	    	}
		}
	}
	
	public int[] getDrawCoords(int dir, ButtonStrategy b){
		int[] ret={0,0,0,0}; //x1 y1 x2 y2
		int w=b.getWidth();
		int h=b.getWidth();
		int wd=w/2;
		int hd=h/2;
    	switch(dir){
			case Direction.UP:
				 ret[0]=wd; ret[1]=0; ret[2]=wd; ret[3]=hd;
				break;
			case Direction.DOWN:
				 ret[0]=wd; ret[1]=hd; ret[2]=wd;ret[3]= h;
				break;
			case Direction.LEFT:
				 ret[0]=0; ret[1]=hd; ret[2]=wd;ret[3]= hd;
				break;
			case Direction.RIGHT:
				 ret[0]=wd; ret[1]=hd; ret[2]=w;ret[3]= hd;
				break;
    	}
		return ret;		
	}
	
	public int[] getDrawImgCoords(int dir, ButtonStrategy b,boolean half){
		return new int[]{0,0};
	}
	
	
}
