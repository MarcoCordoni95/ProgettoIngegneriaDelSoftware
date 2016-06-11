package it.unimi.di.sweng.lasergame;

import java.util.ArrayList;

public class Main {
	public static void main(String [] args){
		ConsoleView c = new ConsoleView();
		ArrayList<ArrayList<Cell>> tab = new ArrayList<ArrayList<Cell>>();
		
		ArrayList<Cell> hardcoded = new ArrayList<Cell>();
		Cell nuova=new Cell(null);
		nuova.setLaser(new Laser(Direction.LEFT));
		hardcoded.add(nuova);
		
		nuova=new Cell(null);
		nuova.setLaser(new Laser(Direction.UP));
		hardcoded.add(nuova);
		
		nuova=new Cell(null);
		Mirror m = new Mirror();
		m.setDirection(1);
		nuova.setMirror(m);
		hardcoded.add(nuova);
		
		nuova=new Cell(null);
		m = new Mirror();
		m.setDirection(3);
		nuova.setMirror(m);
		hardcoded.add(nuova);
		
		nuova=new Cell(null);
		m = new Mirror();
		nuova.setLaser(new Laser(Direction.LEFT));
		nuova.setLaser(new Laser(Direction.DOWN));
		m.setDirection(3);
		nuova.setMirror(m);
		hardcoded.add(nuova);
		tab.add(hardcoded);
		
		
		for(int i = 1; i<5; i++){
			ArrayList<Cell> local = new ArrayList<Cell>();
			for(int j=0; j<5; j++){
				nuova = new Cell(null);
				local.add(nuova);
				double dice = Math.random();
				if(dice<0.1){
					nuova.setLaser(new Laser(0));
					nuova.setLaser(new Laser(3));
				}
				else if(dice <0.3){
					nuova.setLaser(new Laser(  ((int)(Math.random()*10)%3) ));
				}
				else if(dice<0.5){
					double rdir = Math.random();
					int dir;
					if(rdir<0.5)
						dir=1;
					else
						dir=3;
					m  = new Mirror();
					m.setDirection(dir);
					nuova.setMirror(new Mirror());
				}
			}
			tab.add(local);
		}
		
		c.setTabel(tab);
		c.showAll();
	}

}
