package it.unimi.di.sweng.lasergame;

public abstract class AbstractController {

	protected Model model;
	protected ViewInterface view;
	public abstract void updateModel();
	
	static AbstractController controller=null;
	
	private AbstractController(Model m, ViewInterface v) {
		model=m;
		view=v;
		controller=this;
	}
	
	public static AbstractController getController(){
		return controller;		
	}
		
}
