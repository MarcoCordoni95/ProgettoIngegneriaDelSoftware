package it.unimi.di.sweng.lasergame;

import java.util.ArrayList;

import Model.CellStrategy;
import Model.MirrorCell;
import Model.TargetCell;

public class ConsoleDraw implements CellDrawStrategy{	
	
	@Override
	public void draw(CellStrategy c) {
		ArrayList<Laser> lasers = c.getLaser();
		if(c instanceof TargetCell){
			System.out.print("T ");
		}
		else if(c instanceof MirrorCell){
			MirrorCell s = (MirrorCell) c;
			if(s.getOrientation()==1){
				System.out.print("\\ ");
			}
			else{
				System.out.print("/ ");
			}
		}
		else if(lasers.size()>0){
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
		}
		else{
			System.out.print(". ");
		}
	}

	
}
