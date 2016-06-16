package it.unimi.di.sweng.lasergame;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import Controller.Controller;
import Model.CellStrategy;
import Model.Model;

public class ConsoleView implements Observer, ViewInterface{

	private Controller controller;
	private ArrayList<ArrayList<CellStrategy>> tabella;
	private CellDrawStrategy strategy;
	int punteggio;
	int mosse;
	
	private final String help="q -> uscita\nm x y x1 y1 -> sposta lo specchio dalle coordinare x y a x1 y1\nr x y -> ruota lo specchio alle coordinate x y\n";
	
	public ConsoleView(){
		strategy=new ConsoleDraw();
	}

	

	@Override
	public void showAll() {
		int i=0;
		System.out.print("Digitare ? per Lista comandi\n   ");
		for(int j=0; j<5; j++){
			System.out.print(Integer.toString(j)+" ");
		}
		System.out.println();
		for(ArrayList<CellStrategy> row: tabella){
			System.out.print(Integer.toString(i)+") ");
			i++;
			for(CellStrategy x: row){
				strategy.draw(x);
			}
			System.out.println();
		}
		System.out.println("Mosse: "+Integer.toString(mosse)+" Punteggio: "+Integer.toString(punteggio)+"\n>>");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Model m = (Model) arg0;
		setTable(m.getTabel());
		mosse=m.getCount();
		punteggio=m.getScore();
		showAll();
		if(m.getWin()){
			System.out.println("VITTORIA! "+Integer.toString(punteggio)+" punti in "+Integer.toString(mosse)+" mosse.");
			System.exit(0);
		}
		else{
			read();
		}
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
	public void addController(Controller c){
		controller=c ;
	}
	
	public void read(){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String letta = reader.readLine();
			if(letta.contains("m")){
				letta=letta.substring(letta.indexOf('m')+1);
				System.out.println(letta);
				Scanner scanner = new Scanner(letta);
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				int tx = scanner.nextInt();
				int ty = scanner.nextInt();
				scanner.close();
				controller.move(y,x,ty,tx);
			}
			else if(letta.contains("r")){
				letta=letta.substring(letta.indexOf('r')+1);
				Scanner scanner = new Scanner(letta);
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				scanner.close();
				controller.rotate(y,x);
			}
			else if(letta.contains("q")){
				System.exit(0);
			}
			else if(letta.contains("?")){
				System.out.println(help);
				showAll();
				read();
			}
			
		} catch (IOException e) {
			showAll();
			read();
		}
		
	}
	
	public void start(){
		showAll();
	}
	
	

}
