package GraphicView;

import javax.swing.JButton;

public abstract class ButtonStrategy extends JButton{
	private String whoamI;
	public ButtonStrategy(int i,String c){
		super(c+"");
		this.whoamI=c;
		this.setName(""+i);
	}
	
	
}
