package it.unimi.di.sweng.lasergame;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JComponentFixture;
import org.assertj.swing.fixture.JLabelFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class TestScoreDisplay {
	
	private FrameFixture window;
	private ShareScore sc = new ShareScore();
	private ScoreDisplay sd = new ScoreDisplay(sc);
	
	@Test
	public void testScoreDisplay() {		
		//ScoreDisplay sd = new ScoreDisplay(sc);
		sc.addObserver(sd);
		assertEquals(sd.getScoreView(),0);
		sc.setScore(20);
		assertEquals(sd.getScoreView(),20);
		sc.setScore(30);
		assertEquals(sd.getScoreView(),30);
	}
	
	/*@Test
	public void testTextField() {
		//JLabelFixture
		//JComponentFixture
		//JLabelComponentFixture
		//JLabelFixture jlf = new JLabelFixture();
		JLabelFixture textBox = window.textBox();
		textBox.deleteText().enterText("30");
		assertEquals(textBox.text(),"30");	
		textBox.deleteText().enterText("20");
		assertEquals(textBox.text(),"20");
	}
		
	@Before
	public void setUp() {
		JFrame frame = GuiActionRunner.execute(() -> new JFrame());
		JPanel panel = GuiActionRunner.execute(() -> new JPanel());
		//JDialog dialog = GuiActionRunner.execute(() -> new JDialog());
		
		ScoreDisplay sd = GuiActionRunner.execute(() -> new ScoreDisplay(sc));
	
		panel.add(sd);	
		frame.add(panel);	
		frame.pack();
	
		window = new FrameFixture(frame);
		window.show();		
	}	
	
	@After
	public void tearDown(){
		window.cleanUp();
	}*/
}
