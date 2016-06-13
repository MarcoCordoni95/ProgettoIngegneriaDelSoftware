package it.unimi.di.sweng.lasergame;


import java.util.ArrayList;

import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import it.unimi.di.sweng.lasergame.ConsoleView;
import it.unimi.di.sweng.lasergame.Laser;

public class TMain {
	
	public static void main(String [] args){
		ConsoleView view = new ConsoleView();
		ArrayList<ArrayList<CellStrategy>> tab = new ArrayList<ArrayList<CellStrategy>>();
		
		ArrayList<CellStrategy> hardcoded = new ArrayList<CellStrategy>();
		EmptyCell nuova=new EmptyCell();
		nuova.setLaser(new Laser(Direction.LEFT));
		hardcoded.add(nuova);
		
		nuova=new EmptyCell();
		nuova.setLaser(new Laser(Direction.UP));
		hardcoded.add(nuova);
		
		MirrorCell m=new MirrorCell(1);
		hardcoded.add(nuova);
		
		m = new MirrorCell(3);
		hardcoded.add(m);
		
		m = new MirrorCell(3);
		m.setLaser(new Laser(Direction.LEFT));
		m.setLaser(new Laser(Direction.DOWN));
		hardcoded.add(m);
		tab.add(hardcoded);
		
		view.setTable(tab);
		hardcoded = new ArrayList<CellStrategy>();
		nuova=new EmptyCell();
		nuova.setLaser(new Laser(Direction.LEFT));
		hardcoded.add(nuova);
		
		nuova=new EmptyCell();
		nuova.setLaser(new Laser(Direction.UP));
		hardcoded.add(nuova);
		
		m=new MirrorCell(1);
		hardcoded.add(nuova);
		
		m = new MirrorCell(3);
		hardcoded.add(m);
		
		m = new MirrorCell(3);
		m.setLaser(new Laser(Direction.LEFT));
		m.setLaser(new Laser(Direction.DOWN));
		hardcoded.add(m);
		tab.add(hardcoded);
		view.showAll();
	
	}

}
