package co.edu.uptc.view;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;

public class Frame extends JFrame{

	private GamePanel gamePanel;
	private int level;
	
	public Frame(ActionListener actionListener, int level) {
		super("Towers of Hanoi");
		this.level = level;
		this.setSize(820,620);
		this.initComponents(actionListener);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener) {
		gamePanel = new GamePanel(actionListener, this.level, this.getWidth(), this.getHeight());
		add(gamePanel);
	}
	
	public void moveDisk(int numberTowerToMove, boolean flag) {
		gamePanel.moveDisk(numberTowerToMove, flag);
	}
	
	public DiskPanel getOutDisk(int numberTowerToGet) {
		return gamePanel.getOutDisk(numberTowerToGet);
	}
}
