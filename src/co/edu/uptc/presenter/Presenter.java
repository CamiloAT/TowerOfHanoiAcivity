package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.uptc.model.Tower;
import co.edu.uptc.view.Frame;

public class Presenter implements ActionListener{

	private Tower tower;
	private Frame frame;
	
	public Presenter() {
		tower = new Tower(5);
		frame = new Frame(this, 10);
	}
	
	public Tower getTower() {
		return tower;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();
		switch (source) {
		case "Stick1":
			frame.moveDisk(1, 2, true);
			break;

		default:
			break;
		}
		
	}

	public static void main(String[] args) {
		Presenter presenter = new Presenter();
		presenter.getTower().moveDisk(1, 3);
	}
	
}
