package it.unimi.di.sweng.lasergame;

import java.io.IOException;

import Controller.Controller;
import GraphicView.GraphicView;
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
