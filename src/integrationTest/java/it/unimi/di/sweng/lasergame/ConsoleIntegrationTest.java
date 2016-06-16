package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.*;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;


import Controller.Controller;
import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import Model.Model;
import Model.TargetCell;

public class ConsoleIntegrationTest {
	
	@Rule
	public final SystemOutRule output = new SystemOutRule().enableLog();
	
	@Rule
	public final TextFromStandardInputStream systemInMock  = emptyStandardInputStream();
	
	@Test 
	public void test(){
		Model m=new Model(new Laser());
		ConsoleView x=new ConsoleView(false);
		Controller cont=new Controller(m,x);
		x.addController(cont);
		m.addObserver(x);		
		
		String expected = ""
				+"Digitare ? per Lista comandi\n"
				+ "   0 1 2 3 4 \n"
				+ "0) . . . . . \n"
				+ "1) / - - - \\ \n"
				+ "2) | . T . | \n"
				+ "3) + - - - / \n"
				+ "4) | . / . . \n"
				+ "Mosse: 1 Punteggio: 14\n"
				+ ">>\n"
				+"Digitare ? per Lista comandi\n"
				+ "   0 1 2 3 4 \n"
				+ "0) . . . . . \n"
				+ "1) / - - - \\ \n"
				+ "2) | . T . | \n"
				+ "3) + - - - / \n"
				+ "4) | . \\ . . \n"
				+ "Mosse: 2 Punteggio: 14\n"
				+ ">>\n"
				+"Digitare ? per Lista comandi\n"
				+ "   0 1 2 3 4 \n"
				+ "0) . . . . . \n"
				+ "1) / - - - \\ \n"
				+ "2) | . T . | \n"
				+ "3) | . \\ - / \n"
				+ "4) | . . . . \n"
				+ "Mosse: 3 Punteggio: 13\n"
				+ ">>\n"
				+"VITTORIA! 13 punti in 3 mosse.\n";				
		
		CellStrategy[][] board={{new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell()}, 
				{new MirrorCell(0),new EmptyCell(),new EmptyCell(),new EmptyCell(),new MirrorCell(1)},
				{new EmptyCell(),new EmptyCell(),new TargetCell(),new EmptyCell(),new EmptyCell()},
				{new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell(), new MirrorCell(0) },
				{new EmptyCell(),new EmptyCell(),new MirrorCell(1),new EmptyCell(),new EmptyCell()}};
		m.setBoard(board);
		systemInMock.provideLines("r 2 4\nm 2 4 2 3\n\n");
		m.updateModel(4, 2, 4, 2);
		assertEquals(expected,output.getLog());
		
	}

}
