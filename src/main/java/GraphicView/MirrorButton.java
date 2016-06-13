package GraphicView;



public class MirrorButton extends ButtonStrategy {
	
	public MirrorButton(int i,String c){//il numero passato sarà un identificatore univoco all'interno della griglia
		super(i,c);
		
	}
	
	public MirrorButton change() {
		if(this.getWhoamI().equals("/"))
			return  new MirrorButton(this.getNumb(),"\\");
		if(this.getWhoamI().equals("\\"))
			return  new MirrorButton(this.getNumb(),"/");
		return null;
		
		
	}
}
