package GraphicView;

import javax.swing.JButton;

import Model.CellStrategy;

public abstract class ButtonStrategy extends JButton{
	private String whoamI;
	private int numb;
	CellStrategy temp;
	boolean images=false;
	public ButtonStrategy(int i,String c,CellStrategy cs){
		super(c+"");
		this.numb=i;
		this.whoamI=c;
		this.setName(""+i);
		temp=cs;
	}
	public String getWhoamI(){
		return this.whoamI;
	}
	public int getNumb(){
		return this.numb;
	}
	
	
}
