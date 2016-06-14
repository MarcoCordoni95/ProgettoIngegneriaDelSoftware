package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import GraphicView.EmptyButton;
import GraphicView.MirrorButton;
import GraphicView.TargetButton;

public class TestButton {
	
	@Test
	public void TestEmptyButton(){
		EmptyButton eb = new EmptyButton(1,null);
		assertEquals(eb.getNumb(),1);
		assertEquals(eb.getWhoamI(),"");
	}
	
	@Test
	public void TestMirrorButton(){
		MirrorButton mb = new MirrorButton(2,"/",null);
		assertEquals(mb.getNumb(),2);
		assertEquals(mb.getWhoamI(),"/");
		mb=mb.change();
		assertEquals(mb.getWhoamI(),"\\");
		mb=mb.change();
		assertEquals(mb.getWhoamI(),"/");
	}
	
	@Test
	public void TestTargetButton(){
		TargetButton tb = new TargetButton(3,"t",null);
		assertEquals(tb.getNumb(),3);
		assertEquals(tb.getWhoamI(),"t");
	}

}
