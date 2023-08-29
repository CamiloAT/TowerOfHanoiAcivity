package co.edu.uptc.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.model.Level;
import co.edu.uptc.view.myComponents.CustomFont;
import co.edu.uptc.view.myComponents.IconJLabel;
import co.edu.uptc.view.myComponents.MyButton;

public class Menu extends JPanel {
    private JLabel tittleLabel;
    private JLabel tiColorLabel;
    private JLabel tiColorFooterLabel;
    private JLabel infLabel;
    private JComboBox comboBoxLevel;
    private JButton buttonPlay;
    private CustomFont customFont;

    public Menu(ActionListener actionListener, Vector<Level> levels, int width, int height) {
        this.setBackground(Color.white);
        customFont = new CustomFont();
        this.setLayout(null);
        this.initComponents(actionListener, levels, width, height);

    }

    public void initComponents(ActionListener actionListener, Vector<Level> levels, int width, int height) {
        tittleLabel = new IconJLabel("resources/Header.png", 250, 130);
        tittleLabel.setBounds(25, 10, 250, 130);
        add(tittleLabel);

        tiColorLabel = new IconJLabel("resources/HeaderColor.png", 600, 160);
        tiColorLabel.setBounds(width / 2 - 100, 0, 600, 160);
        add(tiColorLabel);

        tiColorFooterLabel = new IconJLabel("resources/HeaderColor.png", width, 160);
        tiColorFooterLabel.setBounds(0, height-115, width, 160);
        add(tiColorFooterLabel);

        infLabel = new JLabel("Seleccione nivel");
        infLabel.setFont(customFont.loadFont(20f));
        infLabel.setBounds(width / 2 - 60, height / 2 - 80, 150, 50);
        add(infLabel);

        comboBoxLevel = new JComboBox<>(levels.stream().map(Level::getNameLevel).toArray(String[]::new));
        comboBoxLevel.setBounds(width / 2 - 50, height/2-20, 100, 25);
        add(comboBoxLevel);

        buttonPlay = new MyButton("Jugar", new Color(12, 58, 158), new Color(14, 84, 235), Color.WHITE, Color.WHITE);
        buttonPlay.setBounds(width / 2 - 65, height / 2 + 100, 130, 40);
        buttonPlay.setActionCommand("play");
        buttonPlay.addActionListener(actionListener);
        add(buttonPlay);
    }

    public String returnLevel() {
        return (String) comboBoxLevel.getSelectedItem();
    }
}
