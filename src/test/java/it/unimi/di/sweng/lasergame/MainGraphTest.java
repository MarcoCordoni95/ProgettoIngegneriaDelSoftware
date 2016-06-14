package it.unimi.di.sweng.lasergame;

import javax.swing.UIManager;

import Controller.Controller;
import GraphicView.GraphicView;
import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import Model.Model;
import Model.TargetCell;

public class MainGraphTest {
	public static void main(String[] args) {
		
		CellStrategy[][] board={{new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell()}, // board scelto da me per poter controllare il percorso
				{new MirrorCell(0),new EmptyCell(),new EmptyCell(),new EmptyCell(),new MirrorCell(1)},
				{new EmptyCell(),new EmptyCell(),new TargetCell(),new EmptyCell(),new EmptyCell()},
				{new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell(),new EmptyCell()},
				{new EmptyCell(),new EmptyCell(),new MirrorCell(1),new EmptyCell(),new MirrorCell(0)}};
		Laser l = new Laser();
		l.setDir(Direction.UP);
		Model m=new Model(l);
		m.setBoard(board);


		GraphicView x=new GraphicView(m);
		Controller cont=x.getController();

		m.addObserver(x);

		x.start();
		l.newGetPercorso(board);
		
		UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
		
		for(UIManager.LookAndFeelInfo x1:lafInfo){
			System.out.println(x1.getClassName());
			System.out.println(x1.getName());
		}

	}

}
