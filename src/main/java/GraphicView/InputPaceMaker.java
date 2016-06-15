package GraphicView;

public class InputPaceMaker {
	
	static final int READY=0;
	static final int M_BEGIN = 1;
	static final int M = 2;
	static final int ROTATE=3;
	static final int WAIT=4;
	
	int state;
	
	public InputPaceMaker(){
		state=READY;
	}
	
	public void update(int input){
		switch(state){
			case ROTATE:
				state=READY;
			case M:
				state=READY;			
		}
	}
	
	public void left(){
		switch(state){
		case 0:
			state=M_BEGIN;
			break;

		case 1:
			state=M;
			break;
		}	
	}
	
	public void right(){
		if(state==0)
			state=ROTATE;
		
	}
	
	public void lock(){
		state=WAIT;
	}
	public void release(){
		state=READY;
	}
	public int getState(){
		return state;
	}

}