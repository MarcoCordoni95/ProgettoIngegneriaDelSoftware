package Model;

import it.unimi.di.sweng.lasergame.Laser;

public class TargetCell extends CellStrategy{
	

	private Laser laser;
	public void action (Laser laser) {
		this.laser=laser;
		laser.setWin();
	}
	public boolean iWon(){		return this.laser.getWin();
		
	}
}
