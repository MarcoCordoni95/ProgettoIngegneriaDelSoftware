package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import Model.RandomCells;
import Model.TargetCell;
import it.unimi.di.sweng.lasergame.Laser.Support;

public class TestLaser {

	@Test
	public void TestGetDir(){
		Laser laser1 = new Laser();
		Laser laser2 = new Laser(3);
		assertEquals(laser1.getDir(),1);
		assertEquals(laser2.getDir(),3);
	}
	
	@Test
	public void TestSetDir(){
		Laser laser1 = new Laser();
		laser1.setDir(2);
		assertEquals(laser1.getDir(),2);
	}
	
	@Test
	public void TestGetWin(){
		Laser laser1 = new Laser();
		assertEquals(laser1.getWin(),false);
	}
	
	@Test
	public void TestSetWin(){
		Laser laser1 = new Laser();
		laser1.setWin();
		assertEquals(laser1.getWin(),true);
	}
	
	@Test
	public void TestNewGetPercorso(){
		Laser laser1 = new Laser();
		RandomCells rand=new RandomCells();
		String percorso="";
		
		CellStrategy[][] board={{new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell()}, // board scelto da me per poter controllare il percorso
								{new MirrorCell(0),new EmptyCell(),new EmptyCell(),new EmptyCell(),new MirrorCell(1)},
								{new EmptyCell(),new EmptyCell(),new TargetCell(),new EmptyCell(),new EmptyCell()},
								{new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell()},
								{new EmptyCell(),new EmptyCell(),new MirrorCell(1),new EmptyCell(),new MirrorCell(0)}};
      
       Support[] p =laser1.newGetPercorso(board);
       
       for(Support u : p)
    	   percorso=percorso+ "[" + u.row + "," + u.column + "] " ;
    
       assertEquals("[4,0] [3,0] [2,0] [1,0] [1,1] [1,2] [1,3] [1,4] [2,4] [3,4] [4,4] [4,3] [4,2] [3,2] [2,2] ", percorso);
	}
}
