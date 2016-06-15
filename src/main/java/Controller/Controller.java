package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GraphicView.ButtonStrategy;
import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import Model.Model;
import it.unimi.di.sweng.lasergame.ViewInterface;

public class Controller implements ActionListener {

	int c = 0, x, x1, y1, y;
	protected CellStrategy[][] board;

	protected Model model;
	protected ViewInterface view;

	public Controller(Model m, ViewInterface v) {
		model = m;
		view = v;
		board = m.getBoard();
	}

	public void setDiff(String s) {
		if (s.equals("Easy"))
			this.model.setDifficulty(1);
		if (s.equals("Normal"))
			this.model.setDifficulty(3);
		if (s.equals("Hard"))
			this.model.setDifficulty(5);
		if (s.equals("Pierlauro!"))
			this.model.setDifficulty(7);
	}

	public void setColor(String s){
		if (s.equals("Easy"))
			this.model.setDifficulty(1);
		if (s.equals("Easy"))
			this.model.setDifficulty(1);
		if (s.equals("Easy"))
			this.model.setDifficulty(1);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		c++;
		ButtonStrategy butt = (ButtonStrategy) e.getSource();

		if (c == 1) {
			int n = Integer.parseInt(butt.getName());
			x = n / 5;
			y = n % 5;
			if (!(board[x][y] instanceof MirrorCell))
				c = 0;
			}

		if (c == 2) { 
			int n = Integer.parseInt(butt.getName());
			x1 = n / 5;
			y1 = n % 5;

			if (x == x1 && y == y1)
				move(x, y, x1, y1);

			if (board[x1][y1] instanceof EmptyCell) { 
				move(x, y, x1, y1);
				c = 0;
			}
			c = 0;
		}
	}

	public void move(int x, int y, int x1, int y1) {
		model.updateModel(x, y, x1, y1);
	}
	public void rotate(int x, int y){
		model.updateModel(x, y, x, y);
	}
}
