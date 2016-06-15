package GraphicView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import Controller.Controller;
import Model.CellStrategy;
import Model.EmptyCell;
import Model.MirrorCell;
import Model.Model;

import Model.TargetCell;
import it.unimi.di.sweng.lasergame.ViewInterface;

public class GraphicView extends JFrame implements ViewInterface, Observer {

	private Model model;
	private Controller cont;
	private JPanel buttonGrid;
	private JPanel optionGrid;

	private JComboBox<String> choice,lasers;
	

	public GraphicView(Model m) {
		super("Laser Game");
		this.setLookandFeel();
		Container co = this.getContentPane();
		co.setLayout(new BorderLayout());

		this.cont = new Controller(m, this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.model = m;

		this.choice = new JComboBox<>(this.model.getDifficulties());
		this.lasers=new JComboBox<>(this.model.getLasers());
		
		this.buttonGrid = new JPanel(new GridLayout(5, 5));
		this.optionGrid = new JPanel(new BorderLayout());

		this.addOption();
		this.addButton();

		co.add(optionGrid, BorderLayout.NORTH);
		co.add(buttonGrid, BorderLayout.CENTER);

	}

	private void addOption() {
		JLabel scoreL = new JLabel("Score: " + this.model.getScore());
		JLabel nMoves = new JLabel("N°moves: " + this.model.getCount());

		this.optionGrid.setSize(200, 100);

		JPanel option = new JPanel(new FlowLayout());
		this.choice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> jcmbType = (JComboBox<String>) e.getSource();
				String cmbType = (String) jcmbType.getSelectedItem();
				cont.setDiff(cmbType);
			}
		});
		option.add(this.choice);
		this.optionGrid.add(option, BorderLayout.WEST);
		
		
		
		JLabel laserSelectorLabel = new JLabel("Select Laser:");
		this.lasers.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageDemon id = ImageDemon.getImageDemon();
				JComboBox<String> jcmbType = (JComboBox<String>) e.getSource();
				String cmbType = (String) jcmbType.getSelectedItem();
				
					id.changeColor(cmbType);
				
				showAll();
			}

		});
		
		option.add(laserSelectorLabel);
		option.add(this.lasers);
		this.optionGrid.add(this.lasers,BorderLayout.CENTER);
		
		JPanel info = new JPanel(new FlowLayout());

		
		info.add(scoreL);
		info.add(nMoves);
		this.optionGrid.add(info, BorderLayout.EAST);

	}

	public void start() {

		this.setSize(500, 500);

		this.setVisible(true);

	}

	private void setLookandFeel() {

		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			try {

				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (Exception ex) {
			}
		}

	}

	private void addButton() {
		CellStrategy[][] board = this.model.getBoard();
		ButtonStrategy b = null;
		int i = 0;
		String s = "";

		for (int r = 0; r < 5; r++)
			for (int c = 0; c < 5; c++) {
				if (board[r][c] instanceof EmptyCell) {
					b = new EmptyButton(i++, board[r][c]);
					b.addActionListener(this.cont);
					this.buttonGrid.add(b);
				} else if (board[r][c] instanceof MirrorCell) {
					int x = ((MirrorCell) board[r][c]).getOrientation();
					if (x == 0)
						s = "/";
					else
						s = "\\";
					b = new MirrorButton(i++, s, board[r][c]);
					b.addActionListener(this.cont);

					this.buttonGrid.add(b);

				} else if (board[r][c] instanceof TargetCell) {
					b = new TargetButton(i++, "Target", board[r][c]);
					b.addActionListener(this.cont);
					this.buttonGrid.add(b);

				}

			}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		showAll();

	}

	public Controller getController() {

		return this.cont;
	}

	@Override
	public void showAll() {
		this.buttonGrid.removeAll();
		this.optionGrid.removeAll();
		
		this.addOption();
		this.addButton();
		
		this.optionGrid.revalidate();
		this.optionGrid.repaint();
		this.buttonGrid.revalidate();
		this.buttonGrid.repaint();
		String s = this.model.isPierlauro();
		if (s != null) {
			JOptionPane.showMessageDialog(this, s);
			this.model.setNewBoard();

		}

	}
}
