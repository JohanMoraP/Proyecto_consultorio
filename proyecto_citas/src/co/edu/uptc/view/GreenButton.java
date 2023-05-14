package co.edu.uptc.view;

import java.awt.Color;

import javax.swing.JButton;

public class GreenButton extends JButton {

    public GreenButton(String text) {
        setForeground(Color.WHITE);
        setUI(new RoundedButtonUI());
        setText(text);
        setBorderPainted(false);
    }

}
