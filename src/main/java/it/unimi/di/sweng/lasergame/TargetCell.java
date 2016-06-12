package it.unimi.di.sweng.lasergame;

public class TargetCell extends CellStrategy{
		
	public void action (Laser laser) {
		laser.setWin();
	}
}
