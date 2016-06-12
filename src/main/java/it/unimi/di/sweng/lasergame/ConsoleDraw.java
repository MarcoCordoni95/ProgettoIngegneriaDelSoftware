package it.unimi.di.sweng.lasergame;

import java.util.ArrayList;

public class ConsoleDraw implements CellDrawStrategy{
	private final String DEFAULT = " \033[0m"; 
	private final String GREY = "\033[37m";
	private final String RED = "\033[31m";
	
	
	@Override
	public void draw(CellStrategy c) {
		ArrayList<Laser> lasers = c.getLaser();
		if(c instanceof MirrorCell){
			MirrorCell s = (MirrorCell) c;
			if(lasers.size()>0){
				System.out.print(RED);
			}
			else{
				System.out.print(GREY);
			}
			if(s.getOrientation()==1){
				System.out.print("/ ");
			}
			else{
				System.out.print("\\ ");
			}
		}
		else if(lasers.size()>0){
			System.out.print(RED);
			if(lasers.size()==2){
				System.out.print("+ ");
			}
			else{
				Laser laser = lasers.get(0);
				switch(laser.getDir()){
				case Direction.UP:
				case Direction.DOWN:
					System.out.print("| ");
				break;
				case Direction.LEFT:
				case Direction.RIGHT:
					System.out.print("- ");
				break;
				}
			}
			System.out.print(DEFAULT);
		}
		else{
			System.out.print(". ");
		}
	}

	
}
