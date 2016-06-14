package GraphicView;

import javax.swing.JButton;

import Model.CellStrategy;

public abstract class ButtonStrategy extends JButton {
	private String whoamI;
	private int numb;
	CellStrategy cell;
	boolean flgImg = true;

	public ButtonStrategy(int i, String c, CellStrategy cs) {
		super("");
		this.numb = i;
		this.whoamI = c;
		this.setName("" + i);
		this.cell = cs;
	}

	public String getWhoamI() {
		return this.whoamI;
	}

	public int getNumb() {
		return this.numb;
	}

	public CellStrategy getCell() {
		return this.cell;
	}

	public boolean getDrawOption() {
		return flgImg;
	}

}
