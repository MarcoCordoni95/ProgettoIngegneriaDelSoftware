package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.MirrorCell;
import Model.TargetCell;

public class TestTargetCell {

	@Test
	public void testAction(){
		TargetCell tc = new TargetCell();
		Laser laser = new Laser();
		assertEquals(laser.getWin(),false);
		tc.action(laser);
		assertEquals(laser.getWin(),true);
	}
}
