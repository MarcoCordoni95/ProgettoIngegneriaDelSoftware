package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import it.unimi.di.sweng.lasergame.Direction;
import it.unimi.di.sweng.lasergame.Laser;
import it.unimi.di.sweng.lasergame.Laser.Support;
import it.unimi.di.sweng.lasergame.ShareScore;

public class Model extends Observable {
	private Laser laser;
	private boolean win = false, lose = false;
	private int difficulty, score, count;
	private CellStrategy[][] board = new CellStrategy[5][5];
	private String[] difficulties = { "Easy", "Normal", "Hard", "Pierlauro!" };

	Support[] colorTrack;

	public Model(Laser laser) {
		this.laser = laser;
		this.setNewBoard();
	}

	public void setNewBoard() {
		for (int r = 0; r < 5; r++)
			for (int c = 0; c < 5; c++)
				this.board[r][c] = null;
		RandomCells random = new RandomCells();
		this.board = random.filler(board);
		this.count = 0;
		this.laser.setDir(Direction.UP);
		this.laser.newGetPercorso(this.board);
		this.score = this.laser.getScore();
		this.win = this.laser.getWin();
		this.updateView(); 
	}

	public String[] getDifficulties() {
		return this.difficulties;
	}

	public void setDifficulty(int i) {
		this.difficulty = i;
	}

	public int getCount() {
		return this.count;
	}

	public int getScore() {
		return this.score;
	}

	public void setBoard(CellStrategy[][] c) {
		board = c;
	}

	public CellStrategy[][] getBoard() {
		return this.board;
	}

	public void updateModel(int x, int y, int x1, int y1) { 
		if (x == x1 && y == y1 && (board[x][y] instanceof MirrorCell))
			((MirrorCell) board[x][y]).setOrientation(); 
		else {
			this.board[x1][y1] = this.board[x][y];
			this.board[x][y] = new EmptyCell(); 
		}
		count++;
		if (this.difficulty > 0) {
			this.score *= difficulty;
			if (this.count > (10 - difficulty)) { 
				this.lose = true;
			}
		}

		this.clearLaser();
		this.colorTrack = laser.newGetPercorso(board);
		this.win = this.laser.getWin();
		if (this.win) {
			ShareScore sc = new ShareScore(this.score);
			sc.share();
		}
		this.score = this.laser.getScore();
		this.updateView();
		}

	public String isPierlauro() {
		if (difficulty == 7) {
			if (this.win) {
				this.laser.setWin(false);
				return "Vedo che ci sei riuscito anche tu! Ma che bravo";
			}
			if (this.lose) {
				this.lose = false;
				return "AHAHAHAHAHA! proprio non ce la fai!!!";
			}
		} else {
			if (this.win) {
				this.laser.setWin(false);
				return "Congratulation! \nYou have bested me this time!\n\n If you liked the game,\n please,\n let the developpers pass.";
			}
			if (this.lose) {
				this.lose = false;
				return "Try Again, if you dare... \nNext time your brain will work better, maybe...";
			}
		}
		return null;
	}

	private void updateView() {
		this.setChanged();
		this.notifyObservers();
	}

	public Support[] getTrack() {
		return this.colorTrack;
	}

	public ArrayList<ArrayList<CellStrategy>> getTabel() {
		ArrayList<ArrayList<CellStrategy>> ret = new ArrayList<ArrayList<CellStrategy>>();
		for (int i = 0; i < 5; i++) {
			ret.add(new ArrayList<CellStrategy>(Arrays.asList((board[i]))));
		}
		return ret;
	}

	public void clearLaser() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j].getLaser().size() > 0) {
					board[i][j].purgeLaser();
				}
			}
		}
		laser = new Laser();
	}
	public boolean getWin(){
		return win;
	}
}