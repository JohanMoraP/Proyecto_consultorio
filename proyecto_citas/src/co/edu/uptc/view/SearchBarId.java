package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchBarId extends JPanel {
    private JLabel searchLabel;
    private JTextField textField;
    private JComboBox<String> items;
    private GreenButton search;

    public SearchBarId(ActionListener listener, String namePanel) {
        setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(getWidth(), 20));
        initComponents(listener, namePanel);
    }

    private void initComponents(ActionListener listener, String namePanel) {
        searchLabel = new JLabel("Buscar Por identificación");
        add(searchLabel);

        textField = new JTextField(20);
        add(textField);
        items = new JComboBox<String>();
        add(items);
        search = new GreenButton("Buscar");
        search.setActionCommand("buscarId" + namePanel);
        search.addActionListener(listener);
        add(search);

    }

    public String getTextIdUser() {
        return textField.getText();
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

}
