package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

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
		
		assertEquals("[2J[;H[0;0f[31m-  [0m[31m|  [0m[31m|  [0m[37m\\ [31m\\ \nMosse: 0 Punteggio: 0\n>>\n",output.getLog());
		
				
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
		assertEquals("[2J[;H[0;0f[31m-  [0m[31m|  [0m[31m|  [0m[37m\\ [31m\\ \nMosse: 0 Punteggio: 0\n>>\n"
				+ "[2J[;H[0;0f[31m-  [0m[31m|  [0m[31m|  [0m[37m\\ [31m\\ \n"
				+ "[31m-  [0m[31m|  [0m[31m|  [0m[37m\\ [31m\\ \nMosse: 0 Punteggio: 0\n>>\n",output.getLog());
		
	}

}
