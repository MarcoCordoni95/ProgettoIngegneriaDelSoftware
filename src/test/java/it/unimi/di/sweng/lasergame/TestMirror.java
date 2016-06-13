package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.MirrorCell;

public class TestMirror {
	
	@Test
	public void testGetOrientation(){
		MirrorCell mir = new MirrorCell(0);
		assertEquals(mir.getOrientation(),0);
	}
	
	@Test
	public void testSetOrientation(){
		MirrorCell mir = new MirrorCell(0);
		mir.setOrientation();
		assertEquals(mir.getOrientation(),1);
	}
	
	@Test
	public void testAction(){
		Laser laser = new Laser(1);
		MirrorCell mir = new MirrorCell(1);
		mir.action(laser);
		assertEquals(laser.getDir(),4);
		mir.action(laser);
		assertEquals(laser.getDir(),1);
		mir.setOrientation();
		mir.action(laser);
		assertEquals(laser.getDir(),3);		
	}


}
