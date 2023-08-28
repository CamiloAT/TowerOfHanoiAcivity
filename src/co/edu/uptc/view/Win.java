package co.edu.uptc.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JDialog;
import javax.swing.JLabel;

import co.edu.uptc.view.myComponents.CustomFont;
import co.edu.uptc.view.myComponents.IconJLabel;

public class Win extends JDialog {
	private JLabel header;
	private JLabel footer;
	private JLabel message;
	private CustomFont customFont;
	
	public Win() {
		this.setTitle("Win");
		this.setLayout(null);
		this.setSize(300,170);
		this.setLocationRelativeTo(this);
		this.getContentPane().setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		customFont = new CustomFont(); 
		this.initComponents();
		this.setVisible(true);
	}
	
	private void initComponents() {		
		header = new IconJLabel("resources/WinHeader.png", this.getWidth(), (int)(this.getHeight()*0.30));
		header.setBounds(0, 0, this.getWidth(), (int)(this.getHeight()*0.30));
		add(header);

		message = new JLabel("GANASTE.");
		message.setFont(customFont.loadFont(30f));
		message.setBounds(this.getWidth()/2-50, this.getHeight()/2-40, 100, 50);
		add(message);
		
		footer = new IconJLabel("resources/WinFooter.png", this.getWidth(), (int)(this.getHeight()*0.20));
		footer.setBounds(0, (int)(this.getHeight()*0.60), this.getWidth(), (int)(this.getHeight()*0.20));
		add(footer);
	}
	
	public void paint(Graphics graphic) {
		super.paint(graphic);
		Graphics2D g2d = (Graphics2D) graphic;
		float[] dash = {10.0f};
		BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash, 0.0f);
		g2d.setStroke(dashed);
		g2d.setColor(new Color(13,128,106,100));
		g2d.drawLine(50, this.getHeight()-170, this.getWidth()-50, this.getHeight()-170);
	}
	
	
	
}
