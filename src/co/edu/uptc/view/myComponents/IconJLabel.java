package co.edu.uptc.view.myComponents;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class IconJLabel extends JLabel{
	private Icon icon;
	
	
	public IconJLabel(String imageURL, int width, int height) {
		icon = new ImageIcon(new ImageIcon(imageURL).getImage().getScaledInstance(width, height, 0));
		this.setIcon(icon);	
	}

		
}
