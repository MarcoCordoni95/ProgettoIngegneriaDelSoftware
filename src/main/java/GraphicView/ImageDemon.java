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
	
	Image laserX;
	Image laserY;
	Image mirror;
	
	public static ImageDemon ImgDem;
	
	public ImageDemon(){
		Image i;
		try {
			laserX = ImageIO.read(ClassLoader.getSystemResourceAsStream("lx.png"));
			laserY = ImageIO.read(ClassLoader.getSystemResourceAsStream("ly.png"));

			
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
	
}
