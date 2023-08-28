package co.edu.uptc.view;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.uptc.model.Level;

public class Frame extends JFrame{
	private final static String MENU = "menu";
	private final static String GAME = "game";
	private JPanel cardLayout;
	private Menu menu;
	private PrincipalGamePanel principalGamePanel;
	private int level;
	
	public Frame(ActionListener actionListener, Vector<Level> levels) {
		super("Towers of Hanoi");
		this.setSize(820,620);
		this.initComponents(actionListener, levels);
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initComponents(ActionListener actionListener, Vector<Level> levels) {
		menu = new Menu(actionListener, levels, this.getWidth(), this.getHeight());
		
		cardLayout = new JPanel();
		cardLayout.setLayout(new CardLayout());
		cardLayout.setBounds(0,0,this.getWidth(), this.getHeight());
		cardLayout.add(menu, MENU);
		
		add(cardLayout);
	}

	public void showGame(ActionListener actionListener, Vector<Level> levels){
		level = levels.stream().filter(u -> u.getNameLevel().equals(returnLevel())).mapToInt(Level::getNumberDisk).findFirst().orElse(-1);
		principalGamePanel= new PrincipalGamePanel(actionListener, levels.stream().filter(u -> u.getNumberDisk() == level).map(Level::getNameLevel).collect(Collectors.joining(" ")) ,this.level, this.getWidth(), this.getHeight());
		cardLayout.add(principalGamePanel, GAME);
		CardLayout card = (CardLayout)(cardLayout.getLayout());
		card.show(cardLayout, GAME);
		cardLayout.revalidate();
		cardLayout.repaint();
	}

	public void showMenu(){
		CardLayout card = (CardLayout)(cardLayout.getLayout());
		card.show(cardLayout, MENU);
	}

	public String returnLevel(){
        return menu.returnLevel();
    }
	
	public void moveDisk(int numberTowerToGet, int numberTowerToMove, boolean flag) {
		principalGamePanel.moveDisk(numberTowerToGet, numberTowerToMove, flag);
	}

	public int getLevel() {
		return level;
	}	
}
