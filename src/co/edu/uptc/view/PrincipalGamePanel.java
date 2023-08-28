package co.edu.uptc.view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.view.myComponents.CustomFont;
import co.edu.uptc.view.myComponents.MyButton;

public class PrincipalGamePanel extends JPanel {
    private GamePanel gamePanel;
    private CustomFont customFont;
    private JLabel tittle;
    private JButton buttonBack;

    public PrincipalGamePanel(ActionListener actionListener, String nameLevel, int level, int width, int height){
        this.setBackground(new Color(201, 240, 246));
        this.setLayout(null);
        customFont = new CustomFont();
        this.initComponents(actionListener, nameLevel, level, width, height);
    }

    public void initComponents(ActionListener actionListener, String nameLevel,  int level, int width, int height){
        gamePanel = new GamePanel(actionListener, level, width-40, height-140);
        gamePanel.setBounds(10, 90, width-40, height-140);
        add(gamePanel);

        tittle = new JLabel(nameLevel);
        tittle.setFont(customFont.loadFont(27f));
        tittle.setBounds(width/2-50, 15, 150, 50);
        add(tittle);

        buttonBack = new MyButton("Atras", new Color(12, 58, 158), new Color(14, 84, 235), Color.WHITE, Color.WHITE);
        buttonBack.setBounds(15, 15, 100, 25);
        buttonBack.setActionCommand("back");
		buttonBack.addActionListener(actionListener);
        add(buttonBack);   
    }

    public void moveDisk(int numberTowerToGet, int numberTowerToMove, boolean flag) {
		gamePanel.moveDisk(numberTowerToGet, numberTowerToMove, flag);
        add(gamePanel);
	}
}
