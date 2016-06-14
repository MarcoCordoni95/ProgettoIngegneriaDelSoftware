package GraphicView;

import Model.CellStrategy;
import Model.TargetCell;

public class TargetButton extends ButtonStrategy{
	
	public TargetButton(int i,String c,CellStrategy cs){//il numero passato sarà un identificatore univoco all'interno della griglia
		super(i,c,cs);
	}
	
	public boolean getWin() {
		
		return ((TargetCell)this.cell).iWon();
	}
}
