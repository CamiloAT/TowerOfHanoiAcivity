package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.uptc.model.Tower;
import co.edu.uptc.persistence.Persistence;
import co.edu.uptc.view.Frame;
import co.edu.uptc.view.GamePanel;

public class Presenter implements ActionListener{

	private Tower tower;
	private Frame frame;
	
	public Presenter() {
		frame = new Frame(this, new Persistence().getLevels());
	}
	
	public Tower getTower() {
		return tower;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "play":
			frame.showGame(this, new Persistence().getLevels());
			tower = new Tower(frame.getLevel());
			break;
		case "back":
			frame.showMenu();
			break;
		case "Stick1":
			if (GamePanel.counter%2==0) {
				frame.getOutDisk(1);
				tower.getStickDisk(1);
			}else {
				frame.moveDisk(1, tower.verifyMoveDisk(1));
				tower.moveDisk(1);
			}
			break;
		case "Stick2":
			if (GamePanel.counter%2==0) {
				frame.getOutDisk(2);
				tower.getStickDisk(2);
			}else {
				frame.moveDisk(2, tower.verifyMoveDisk(2));
				tower.moveDisk(2);
			}
			break;
		case "Stick3":
			if (GamePanel.counter%2==0) {
				frame.getOutDisk(3);
				tower.getStickDisk(3);

			}else {
				frame.moveDisk(3, tower.verifyMoveDisk(3));
				tower.moveDisk(3);
				frame.changeVisible(tower.verifyWinning());
			}
			break;
		default:
			break;
		}
		
	}

	public static void main(String[] args) {
		new Presenter();
	}
	
}