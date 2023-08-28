package co.edu.uptc.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import co.edu.uptc.model.Disk;

public class GamePanel extends JPanel{

	private int level;
	private JButton stick1;
	private JButton stick2;
	private JButton stick3;
	private Vector<DiskPanel> stackStick1;
	private Vector<DiskPanel> stackStick2;
	private Vector<DiskPanel> stackStick3;


	public GamePanel(ActionListener actionListener, int level, int width, int height) {
		this.level = level;
		this.setSize(width, height);
		stackStick1 = this.addDisks();
		stackStick2 = new Stack<>();
		stackStick3 = new Stack<>();
		this.initComponenets(actionListener);
	}

	private void initComponenets(ActionListener actionListener) {
		this.setLayout(null);
		int size = stackStick1.size();
		for (int i = 0; i < size; i++) {
			DiskPanel temp = stackStick1.get((size-1)-i);
			int x = this.getPercentageValueWidth(1, 5);
			int y = this.getPercentageValueHeight(123, 250);
			int a  = (temp.getWidth()/2)+3;
			int b = (temp.getHeight()*i);
			temp.setBounds(x-a, y+b, temp.getWidth(), temp.getHeight());
			add(temp);
		}
		stick1 = new InvisibleButton("");
		stick1.setBounds(this.getPercentageValueWidth(1, 20), this.getPercentageValueHeight(2, 5), this.getPercentageValueWidth(3, 10), this.getPercentageValueHeight(9, 20));
		stick1.setActionCommand("Stick1");
		stick1.addActionListener(actionListener);
		add(stick1);
		stick2 = new InvisibleButton("");
		stick2.setBounds(this.getPercentageValueWidth(7, 20), this.getPercentageValueHeight(2, 5), this.getPercentageValueWidth(3, 10), this.getPercentageValueHeight(9, 20));
		stick2.setActionCommand("Stick2");
		stick2.addActionListener(actionListener);
		add(stick2);
		stick3 = new InvisibleButton("");
		stick3.setBounds(this.getPercentageValueWidth(13, 20), this.getPercentageValueHeight(2, 5), this.getPercentageValueWidth(3, 10), this.getPercentageValueHeight(9, 20));
		stick3.setActionCommand("Stick3");
		stick3.addActionListener(actionListener);
		add(stick3);
	}

	private Vector<DiskPanel> addDisks() {
		Vector<DiskPanel> disks = new Vector<>();
		for (int i = 0; i < this.level; i++) {
			disks.add(new DiskPanel(this.getPercentageValueWidth(28-((28/this.level)*i)), this.getPercentageValueHeight(35/this.level)));
		}
		return disks;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(159,103,49,255));
		g2d.setStroke(new BasicStroke(10));
		g2d.drawLine(this.getPercentageValueWidth(1, 20), this.getPercentageValueHeight(9, 10), this.getPercentageValueWidth(19, 20), this.getPercentageValueHeight(9, 10));
		g2d.drawLine(this.getPercentageValueWidth(1, 5), this.getPercentageValueHeight(9, 10), this.getPercentageValueWidth(1, 5), this.getPercentageValueHeight(1, 2));
		g2d.drawLine(this.getPercentageValueWidth(1, 2), this.getPercentageValueHeight(9, 10), this.getPercentageValueWidth(1, 2), this.getPercentageValueHeight(1, 2));
		g2d.drawLine(this.getPercentageValueWidth(4, 5), this.getPercentageValueHeight(9, 10), this.getPercentageValueWidth(4, 5), this.getPercentageValueHeight(1, 2));

	}

	private Vector<DiskPanel> selectTower(int numberTower){
		Vector<DiskPanel> output = new Vector<>();
		switch (numberTower) {
		case 1:
			output = this.stackStick1;
			break;
		case 2:
			output = this.stackStick2;
			break;
		case 3:
			output = this.stackStick3;
			break;
		}
		return output;
	}
	
	private DiskPanel getStickDisk(int numberTower) {
		Vector<DiskPanel> stick = this.selectTower(numberTower);
		return stick.get(stick.size()-1);
	}

	private int getPositionToIncrease(int numberTowerToGet) {
		return this.getStickDisk(numberTowerToGet).getX();
	}
	
	public DiskPanel getOutDisk(int numberTowerToGet) {
		DiskPanel disk = this.getStickDisk(numberTowerToGet);
		disk.setLocation(this.getPositionToIncrease(numberTowerToGet), disk.getY()-50);
		return disk;
	}
	
	public void moveDisk(int numberTowerToGet, int numberTowerToMove, boolean flag) {
		DiskPanel disk = this.getOutDisk(numberTowerToGet);
		Vector<DiskPanel> stickToMove = this.selectTower(numberTowerToMove);
		Vector<DiskPanel> stickToRemove = this.selectTower(numberTowerToMove);
		if (flag) {
			stickToMove.add(disk);
		}
	}
	
	private int getPercentageValueWidth(int multiplier, int divider) {
		return (this.getWidth()*multiplier)/divider;
	}

	private int getPercentageValueWidth(int multiplier) {
		return (this.getWidth()*multiplier)/100;
	}

	private int getPercentageValueHeight(int multiplier, int divider) {
		return (this.getHeight()*multiplier)/divider;
	}

	private int getPercentageValueHeight(int multiplier) {
		return (this.getHeight()*multiplier)/100;
	}
}
