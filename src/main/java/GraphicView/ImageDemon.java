package GraphicView;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.sun.org.apache.bcel.internal.util.ClassLoader;

import it.unimi.di.sweng.lasergame.Direction;
public class ImageDemon {
	
	ImageIcon laserX;
	ImageIcon laserY;
	ImageIcon mirror;
	
	public ImageDemon(){
		Image i;
		try {
			i = ImageIO.read(ClassLoader.getSystemResourceAsStream("lx.png"));
			laserX = new ImageIcon(i);
			i = ImageIO.read(ClassLoader.getSystemResourceAsStream("ly.png"));
			laserY = new ImageIcon(i);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}					
	}
	
	public void drawLaser(JButton b, int direction){
		switch(direction){
	case Direction.DOWN:
	case Direction.UP:
			b.setIcon(laserY);
		break;
		case Direction.LEFT:
		case Direction.RIGHT:
			b.setIcon(laserX);
		break;
		}
		
	}

	
	public void drawMirror(JButton b, int direction){
		
	}

	public ImageIcon getY(){
		return laserY;
	}
	
	public ImageIcon getX(){
		return laserX;
	}
	
}
