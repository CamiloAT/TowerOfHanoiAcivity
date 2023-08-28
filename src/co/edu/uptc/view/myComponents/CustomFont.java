package co.edu.uptc.view.myComponents;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class CustomFont {
	private Font font;

    public Font loadFont(float size) {
    	try{
			font = Font.createFont(Font.TRUETYPE_FONT, new File("resources/balloons.ttf")).deriveFont(size);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/balloons.ttf")));			
		}
		catch(IOException | FontFormatException e){
		}
    	
		return font;
    }
}