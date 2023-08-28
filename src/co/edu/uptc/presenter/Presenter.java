package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import co.edu.uptc.model.Level;
import co.edu.uptc.model.Tower;
import co.edu.uptc.view.Frame;
import co.edu.uptc.view.Win;

public class Presenter implements ActionListener{

	private Tower tower;
	private Frame frame;
	private Win win;
	Vector<Level> levels = new Vector<>();
	
	public Presenter() {
		levels.add(new Level("Avanzado", 5));
		levels.add(new Level("Medio", 4));
		levels.add(new Level("novato", 3));
		levels.add(new Level("Principiante", 2));

		frame = new Frame(this, levels);
		tower = new Tower(frame.getLevel());
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
				
			case "play":
				frame.showGame(this, levels);
				break;

			case "back":
				frame.showMenu();
				win = new Win();
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
