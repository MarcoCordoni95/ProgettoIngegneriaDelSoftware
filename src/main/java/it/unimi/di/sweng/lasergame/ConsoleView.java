package it.unimi.di.sweng.lasergame;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class ConsoleView implements Observer, ViewInterface{

	private AbstractController controller;
	private ArrayList<ArrayList<CellStrategy>> tabella;
	private CellDrawStrategy strategy;
	int punteggio;
	int mosse;
	
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
		for(ArrayList<CellStrategy> row: tabella){
			for(CellStrategy x: row){
				strategy.draw(x);
			}
			System.out.println();
		}
		System.out.println("Mosse: "+Integer.toString(mosse)+" Punteggio: "+Integer.toString(punteggio)+"\n>>");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		setTable(((Model)arg0).getTabel());
		showAll();
		read();
	}
	
	public void setTable(ArrayList<ArrayList<CellStrategy>> arrayList){
		tabella=arrayList;
	}
	
	public void setMoves(int m){
		mosse=m;
	}
	public void setScore(int p){
		punteggio=p;
	}
	
	public void read(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String letta = reader.readLine();
			if(letta.contains("m")){
				letta=letta.substring(letta.indexOf('m'));
				Scanner scanner = new Scanner(letta);
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int tx = scanner.nextInt();
				int ty = scanner.nextInt();
				
				controller.move(x,y,tx,ty);
			}
			else if(letta.contains("r")){
				letta=letta.substring(letta.indexOf('r'));
				Scanner scanner = new Scanner(letta);
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				controller.rotate(x,y);
			}
			else if(letta.contains("q")){
				System.exit(0);
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	

}
