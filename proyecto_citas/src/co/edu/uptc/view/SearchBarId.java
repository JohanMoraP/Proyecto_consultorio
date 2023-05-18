package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchBarId extends JPanel {
    private JLabel searchLabel;
    private JTextField textField;
    private GreenButton search;

    public SearchBarId() {
        setBackground(Color.WHITE);
        this.setSize(new Dimension(getWidth(), (int) (getHeight() * 0.2)));
        initComponents();
    }

    private void initComponents() {
        searchLabel = new JLabel("Buscar Por identificación");
        add(searchLabel);

        textField = new JTextField(20);
        add(textField);

        search = new GreenButton("Buscar");
        add(search);

    }

}
