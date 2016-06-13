package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.MirrorCell;

public class TestMirror {
	
	@Test
	public void testSetOrientation(){
		MirrorCell mir = new MirrorCell(0);
		assertEquals(mir.getOrientation(),0);
		mir.setOrientation();
		assertEquals(mir.getOrientation(),1);
	}

}
