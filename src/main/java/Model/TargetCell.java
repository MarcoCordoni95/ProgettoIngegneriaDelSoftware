package Model;

import it.unimi.di.sweng.lasergame.CellStrategy;
import it.unimi.di.sweng.lasergame.Laser;

public class TargetCell extends CellStrategy{
	

	
	public void action (Laser laser) {
		laser.setWin();
	}
}
