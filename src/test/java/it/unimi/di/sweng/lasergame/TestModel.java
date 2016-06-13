package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Model.MirrorCell;
import Model.Model;
import Model.TargetCell;

public class TestModel {
	
	@Test
	public void testCount(){
		Laser laser = new Laser();
		Model model = new Model(laser);
		assertEquals(model.getCount(),0);
	}

	@Test
	public void testUpdateModel(){
		Laser laser = new Laser();
		Model model = new Model(laser);
		model.updateModel(0, 0, 1, 1);
		assertEquals(model.getCount(),1);		
		model.getBoard()[1][1]=new MirrorCell(0);
		model.updateModel(1, 1, 1, 1);
		assertEquals(model.getCount(),2);
	}
}
