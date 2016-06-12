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
		ArrayList<ArrayList<Cell>> tabel=new ArrayList<ArrayList<Cell>>();
		
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
		tabel.add(hardcoded);		
		
		view.setTable(tabel);
		view.showAll();
		
		assertEquals("[2J[;H[0;0f[31m-  [0m[31m|  [0m[37m/ [37m\\ [31m\\ \nMosse: 0 Punteggio: 0\n>>\n",output.getLog());
		
		
		hardcoded = new ArrayList<Cell>();
		nuova=new Cell(null);
		nuova.setLaser(new Laser(Direction.LEFT));
		hardcoded.add(nuova);
		
		nuova=new Cell(null);
		nuova.setLaser(new Laser(Direction.UP));
		hardcoded.add(nuova);
		
		nuova=new Cell(null);
		m = new Mirror();
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
		tabel.add(hardcoded);
		view.showAll();
		assertEquals("[2J[;H[0;0f[31m-  [0m[31m|  [0m[37m/ [37m\\ [31m\\ \nMosse: 0 Punteggio: 0\n>>\n"
				+ "[2J[;H[0;0f[31m-  [0m[31m|  [0m[37m/ [37m\\ [31m\\ \n"
				+ "[31m-  [0m[31m|  [0m[37m/ [37m\\ [31m\\ \nMosse: 0 Punteggio: 0\n>>\n",output.getLog());
		
	}

}
