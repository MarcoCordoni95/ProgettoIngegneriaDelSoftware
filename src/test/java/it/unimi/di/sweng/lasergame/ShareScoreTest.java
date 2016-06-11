package it.unimi.di.sweng.lasergame;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShareScoreTest {

	@Test
	public void testGets() {
		ShareScore s = new ShareScore();
		assertEquals(0,s.getRecord());
		s = new ShareScore(20);
		assertEquals(20,s.getScore());
	}

}
