package it.unimi.di.sweng.lasergame;



import Controller.Controller;

import Model.Model;

public class ConsoleMain {

	public static void main(String[] args){
		Model m=new Model(new Laser());
		ConsoleView x=new ConsoleView();
		Controller cont=new Controller(m,x);
		x.addController(cont);
		m.addObserver(x);
		m.updateModel(0, 0, 0, 0);
	}
}
