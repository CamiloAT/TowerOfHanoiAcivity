package co.edu.uptc.view;

import java.awt.Color;

import javax.swing.JButton;

public class InvisibleButton extends JButton{

	public InvisibleButton(String text) {
		super(text);
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
		this.setBorder(null);
	}
	
}
