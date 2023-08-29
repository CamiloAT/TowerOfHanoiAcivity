package co.edu.uptc.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class DiskPanel extends JPanel{
	
	public DiskPanel(int width, int height) {
		super();
		this.setSize(width, height);
		this.setBackground(new Color(13, 243, 226));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(13, 145, 243));
		g2d.setStroke(new BasicStroke(10));
		g2d.drawRect(0, 0, this.getWidth(), this.getHeight());
	}
}
