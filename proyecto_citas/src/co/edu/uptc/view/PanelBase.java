package co.edu.uptc.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class PanelBase extends JPanel {
    private Home home;

    public PanelBase() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        // TODO Auto-generated method stub
        home = new Home();
        add(home);
    }
}
