package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.CellStrategy;
import Model.RandomCells;

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
		
		CellStrategy[][] board={{null,null,null,null,null},
								{null,null,null,null,null},
								{null,null,null,null,null},
								{null,null,null,null,null},
								{null,null,null,null,null}};
      
       board=rand.filler(board);       
       CellStrategy[] p =laser1.newGetPercorso(board);
       for(CellStrategy u : p)
    	   System.out.println( u );
       
       System.out.println("");
       System.out.println("");
       
       for(int i=0; i<5; i++){
           for(int j=0; j<5; j++)
        	   System.out.print(board[i][j]);
           System.out.println("");
       }

	}
}
