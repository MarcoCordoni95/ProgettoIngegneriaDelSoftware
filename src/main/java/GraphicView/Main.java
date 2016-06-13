package GraphicView;

import javax.swing.UIManager;

import Controller.Controller;
import Model.Model;

public class Main {

	public static void main(String[] args) {
		Model m=new Model(null);
		
		
		
		
		
		
		GraphicView x=new GraphicView(m);
		Controller cont=x.getController();

		m.addObserver(x);
		
		
		
		
		
		
		
		
		
		
		x.start();
		
		
		UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
		
		for(UIManager.LookAndFeelInfo x1:lafInfo){
			System.out.println(x1.getClassName());
			System.out.println(x1.getName());
		}

	}

}
