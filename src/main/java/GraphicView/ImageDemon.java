package GraphicView;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
	Image mirrorR;
	Image mirrorL;
	
	public static ImageDemon ImgDem;
	final Color L_COLOR = Color.red; 
	
	private ImageDemon(){
		try {
			laserX = ImageIO.read(new File("./src/Res/lx.png/"));
			laserY = ImageIO.read(new File("./src/Res/ly.png/"));
			mirrorR = ImageIO.read(new File("./src/Res/mirrorR.png/"));
			mirrorL = ImageIO.read(new File("./src/Res/mirrorL.png/"));
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
		g2.setColor(L_COLOR);
		g2.setStroke(new BasicStroke(2));
		if(!b.getDrawOption()){
	    	for(Laser x: ls){
	    		int[] points = getDrawCoords(Direction.flip(x.getFromDir()),b,false);
	    		g2.drawLine(points[0], points[1], points[2], points[3]);
	    		points=getDrawCoords(x.getDir(),b,false);
	    		g2.drawLine(points[0], points[1], points[2], points[3]);
	    	}
		}
		else
			for(Laser x: ls){
	    		int[] points = getDrawCoords(Direction.flip(x.getFromDir()),b,true);
	    		g2.setColor(L_COLOR);
	    		Image i=null;
	    		if(points[4]==0)
	    			i=laserY;
	    		else
	    			i=laserX;
	    		g2.drawImage(i, points[0], points[1], points[2], points[3], null);
	    		points=getDrawCoords(x.getDir(),b,true);
	    		if(points[4]==0)
	    			i=laserY;
	    		else
	    			i=laserX;
	    		g2.drawImage(i, points[0], points[1], points[2], points[3], null);
			}
	}
	public void drawMirror(ButtonStrategy b, Graphics2D g2){
		int w=b.getWidth();
		int h=b.getWidth();
		if(!b.getDrawOption()){
	        g2.setColor(Color.black);
	        g2.setStroke(new BasicStroke(3));
	        if( b.getWhoamI().equals("/")){
		       g2.drawLine(w, 0, 0,h);	        
	        }
	        else{
	 	       g2.drawLine(0, 0, w, h);	      
	        }
	        g2.setStroke(new BasicStroke(1));
		}
		else{
	        if( b.getWhoamI().equals("/")){
		       g2.drawImage(mirrorR,0,0,w,h,null);
	        }
	        else{
	        	g2.drawImage(mirrorL,0,0,w,h,null);      
	        }
		}
	}
	
	public int[] getDrawCoords(int dir, ButtonStrategy b,boolean isImage){
		int[] ret={0,0,0,0}; //x1 y1 x2 y2
		int w=b.getWidth();
		int h=b.getWidth();
		int wd=w/2;
		int hd=h/2;
		if(!isImage)
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
		else{
			ret=new int[]{0,0,0,0,0};
			switch(dir){
			// [x,y,width,height,Img0_o_Img1?]
				case Direction.UP:
					 ret[0]=0; ret[1]=0; ret[2]=w; ret[3]=hd;ret[4]=0;
					break;
				case Direction.DOWN:
					 ret[0]=0; ret[1]=hd; ret[2]=w;ret[3]= hd;ret[4]=0;
					break;
				case Direction.LEFT:
					 ret[0]=0; ret[1]=0; ret[2]=wd;ret[3]= h;ret[4]=1;
					break;
				case Direction.RIGHT:
					 ret[0]=wd; ret[1]=0; ret[2]=wd;ret[3]= h;ret[4]=1;
					break;
			}
		}
		return ret;		
	}
	
	public int[] getDrawImgCoords(int dir, ButtonStrategy b,boolean half){
		return new int[]{0,0};
	}
	
	
}
