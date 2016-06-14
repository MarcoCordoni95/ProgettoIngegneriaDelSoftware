package Model;

import java.util.ArrayList;

import it.unimi.di.sweng.lasergame.Laser;

public abstract class CellStrategy {
	ArrayList<Laser> laserList = new ArrayList<Laser>();

	public abstract void action(Laser laser);

	public void setLaser(Laser l) {
		this.laserList.add(l);
	}

	public ArrayList<Laser> getLaser() {
		return this.laserList;
	}

	public boolean isSetLaserList() {
		return (laserList.size() != 0);
	}

	/*
	 * da richiamare ogni volta che qualcosa cambia nella board
	 */
	public void purgeLaser() {
		this.laserList.clear();
	}

}