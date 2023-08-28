package co.edu.uptc.model;

import java.util.Stack;

public class Tower {

	private Stack<Disk> firstStick;
	private Stack<Disk> secondStick;
	private Stack<Disk> thirthStick;
	private int level;
	
	public Tower(int level) {
		firstStick = new Stack<>();
		secondStick = new Stack<>();
		thirthStick = new Stack<>();
		this.level = level;
		this.initFirstStick();
	}
	
	private void initFirstStick() {
		while (this.level>0) {
			firstStick.push(new Disk(this.level));
			this.level--;
		}
	}
	
	private Stack<Disk> selectTower(int numberTower){
		Stack<Disk> output = new Stack<>();
		switch (numberTower) {
		case 1:
			output = this.firstStick;
			break;
		case 2:
			output = this.secondStick;
			break;
		case 3:
			output = this.thirthStick;
			break;
		}
		return output;
	}
	
	private Disk getStickDisk(int numberTower) {
		return this.selectTower(numberTower).pop();
	}
	
	public void moveDisk(int numberTowerToGet, int numberTowerToMove) {
		Disk disk = this.getStickDisk(numberTowerToGet);
		Stack<Disk> stick = this.selectTower(numberTowerToMove);
		if (stick.isEmpty()||stick.peek().getWeigth()>disk.getWeigth()) {
			stick.push(disk);
		}
	}
}
