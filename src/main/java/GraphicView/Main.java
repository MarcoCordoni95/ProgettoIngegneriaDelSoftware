package GraphicView;

import javax.swing.UIManager;

import Model.Model;

public class Main {

	public static void main(String[] args) {
		Model m=new Model(null);
		GraphicView x=new GraphicView(m);
		UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
		
		for(UIManager.LookAndFeelInfo x1:lafInfo){
			System.out.println(x1.getClassName());
			System.out.println(x1.getName());
		}

	}

}
