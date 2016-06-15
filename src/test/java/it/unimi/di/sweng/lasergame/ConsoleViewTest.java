package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;

public class ConsoleViewTest {
	
	@Rule
	public final SystemOutRule output = new SystemOutRule().enableLog();
	
	@Test
	public void test0(){
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
		view.showAll();
		
		assertEquals("Digitare ? per Lista comandi\n"+"   0 1 2 3 4 \n"+"0) - | | / / \n"+"Mosse: 0 Punteggio: 0\n"+">>\n",output.getLog());
		
				
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
		assertEquals("Digitare ? per Lista comandi\n"+"   0 1 2 3 4 \n"+"0) - | | / / \n"+"Mosse: 0 Punteggio: 0\n"+">>\n"
				+ "Digitare ? per Lista comandi\n   0 1 2 3 4 \n0) - | | / / \n1) - | | / / \nMosse: 0 Punteggio: 0\n>>\n",output.getLog());
		
	}

}
