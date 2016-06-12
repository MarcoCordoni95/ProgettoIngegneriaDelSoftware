package it.unimi.di.sweng.lasergame;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ConsoleView implements Observer, ViewInterface{

	private AbstractController controller;
	private ArrayList<ArrayList<Cell>> tabella;
	private CellDrawStrategy strategy;
	
	public ConsoleView(){
		strategy=new ConsoleDraw();
	}

	
	@Override
	public void addListener(AbstractController contr) {
		controller=contr;
		
	}

	@Override
	public void showAll() {
		System.out.print("\033[2J\033[;H\033[0;0f");
		for(ArrayList<Cell> row: tabella){
			for(Cell x: row){
				strategy.draw(x);
			}
			System.out.println();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setTabel(((Model)arg0).getTabel());
		showAll();
		
	}
	
	public void setTabel(ArrayList<ArrayList<Cell>>t){
		tabella=t;
	}
	
	
	

}
