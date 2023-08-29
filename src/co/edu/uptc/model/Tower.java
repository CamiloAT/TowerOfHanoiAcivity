package co.edu.uptc.model;

import java.util.Stack;

public class Tower {

	private Stack<Disk> firstStick;
	private Stack<Disk> secondStick;
	private Stack<Disk> thirthStick;
	private Stack<Disk> win;
	private Disk diskUp;
	private int level;
	
	public Tower(int level) {
		firstStick = new Stack<>();
		secondStick = new Stack<>();
		thirthStick = new Stack<>();
		win = new Stack<>();
		this.level = level;
		this.initFirstStick();
	}
	
	public boolean verifyWinning() {
		boolean flag = false;
		if (this.getWeightFromStick(this.thirthStick).equals(this.getWeightFromStick(this.win))) {
			flag = true;
		}
		return flag;
	}
	
	private String getWeightFromStick(Stack<Disk> stick) {
		String output = "";
		for (int i = 0; i < stick.size(); i++) {
			output+=stick.get(i).getWeigth()+",";
		}
		return output;
	}
	
	private void initFirstStick() {
		int temp = this.level;
		while (temp>0) {
			firstStick.push(new Disk(temp));
			win.push(new Disk(temp));
			temp--;
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
	
	public void getStickDisk(int numberTower) {
		diskUp = this.selectTower(numberTower).pop();
	}
	
	public void moveDisk(int numberTowerToMove) {
		Stack<Disk> stick = this.selectTower(numberTowerToMove);
		if (stick.isEmpty()||stick.peek().getWeigth()>this.diskUp.getWeigth()) {
			stick.push(this.diskUp);
		}
	}
	
	public boolean verifyMoveDisk(int numberTowerToMove) {
		boolean flag = false;
		Stack<Disk> stick = this.selectTower(numberTowerToMove);
		if (stick.isEmpty()||stick.peek().getWeigth()>this.diskUp.getWeigth()) {
			flag=true;
		}
		return flag;
	}
}