package co.edu.uptc.view.myComponents;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class MyButton extends JButton implements MouseListener{
	private CustomFont customFont;
	private Color color;
	private Color hover;
	private Color background;
	private Color foreColor;
	private Color foregroundNa;
	private Color foregroundHover;
	
	public MyButton(String text, Color background, Color hover, Color foreground, Color foregroundHover) {
		super(text);
		this.setOpaque(false);
		this.setBorder(new EmptyBorder(10,10,10,15));
		customFont = new CustomFont();
		this.color = background;
		this.background = background;
		this.hover = hover;
		this.foreColor = foreground;
		this.foregroundNa = foreground;
		this.foregroundHover = foregroundHover;
		this.setFont(customFont.loadFont(15f));
		addMouseListener(this);
	}
	
	@Override
	public void paintComponent(Graphics graphic) {
		 Graphics2D g2 = (Graphics2D) graphic.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	        g2.setColor(color);
	        g2.fill(shape);
	        FontMetrics fm = g2.getFontMetrics();
	        Rectangle2D textBounds = fm.getStringBounds(getText(), g2);
	        int x = (int) ((getWidth() - textBounds.getWidth()) / 2);
	        int y = (int) ((getHeight() - textBounds.getHeight()) / 2 + fm.getAscent());
	        g2.setColor(foreColor);
	        g2.drawString(getText(), x, y);
	        g2.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		color = hover;
		this.foreColor = foregroundHover;
		this.repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		color = background;
		this.foreColor = foregroundNa;
		this.repaint();
		
	}
	
	

}
