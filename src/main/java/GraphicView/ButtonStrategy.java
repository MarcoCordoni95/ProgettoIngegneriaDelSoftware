package GraphicView;

import javax.swing.JButton;

public abstract class ButtonStrategy extends JButton{
	private String whoamI;
	private int numb;
	public ButtonStrategy(int i,String c){
		super(c+"");
		this.numb=i;
		this.whoamI=c;
		this.setName(""+i);
	}
	public String getWhoamI(){
		return this.whoamI;
	}
	public int getNumb(){
		return this.numb;
	}
	
	
}
