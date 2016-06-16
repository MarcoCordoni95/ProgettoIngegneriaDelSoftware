package GraphicView;

import java.awt.Graphics;
import java.awt.Graphics2D;

import Model.CellStrategy;

public class TargetButton extends ButtonStrategy {

	public TargetButton(int i, String c, CellStrategy cs) {
		super(i, c, cs);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		ImageDemon id = ImageDemon.getImageDemon();
		id.drawLaserOnly(this, g2);
		id.drawTarget(this, g2);
		g2.dispose();
	}
}
