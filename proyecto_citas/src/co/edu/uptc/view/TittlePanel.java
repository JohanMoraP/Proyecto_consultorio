package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TittlePanel extends JPanel {

    private JLabel tittle;

    public TittlePanel() {
        setBackground(new Color(41, 99, 99));
        this.setSize(getWidth(), 100);
		setAlignmentY(CENTER_ALIGNMENT);
        initComponents();
    }

    private void initComponents() {

        tittle = new JLabel();
        tittle.setForeground(Color.WHITE);
        tittle.setFont(new Font("Product Sans", Font.ITALIC, 30));
        add(tittle);
    }

    public JLabel getTittle() {
        return tittle;
    }

    public void setTittle(JLabel tittle) {
        this.tittle = tittle;
    }

}