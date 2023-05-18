package co.edu.uptc.view.AppointmentPanels;

import java.awt.Color;

import javax.swing.JPanel;

import co.edu.uptc.view.GreenButton;

public class AppointmentButtons extends JPanel {

    private GreenButton cancel;
    private GreenButton save;

    public AppointmentButtons() {
        setBackground(Color.WHITE);
        initComponents();
    }

    private void initComponents() {

        cancel = new GreenButton("Cancelar");
        cancel.setActionCommand("cancelar");
        add(cancel);

        save = new GreenButton("Guardar");
        save.setActionCommand("guardar");
        add(save);

    }
}