package it.unimi.di.sweng.lasergame;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

public class ScoreDisplay extends JTextField implements Observer {
	
	public ScoreDisplay(ShareScore sc){
		super(20);
	}

	@Override
	public void update(Observable sc, Object obj) {
		this.setText(obj.toString());			
	}
	
	public int getScoreView() {
		if(getText().equals(""))
			return 0;
		return Integer.parseInt(getText());
	}
	
}
