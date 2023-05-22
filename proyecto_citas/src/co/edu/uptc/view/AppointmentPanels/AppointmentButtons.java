package co.edu.uptc.view.AppointmentPanels;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import co.edu.uptc.view.GreenButton;

public class AppointmentButtons extends JPanel {

    private GreenButton cancel;
    private GreenButton save;

    public AppointmentButtons(ActionListener listener, String namePanel) {
        setBackground(Color.WHITE);
        initComponents(listener, namePanel);
    }

    private void initComponents(ActionListener listener, String namePanel) {

        cancel = new GreenButton("Cancelar");
        cancel.setActionCommand("cancelar"+namePanel);
        cancel.addActionListener(listener);
        add(cancel);

        save = new GreenButton("Guardar");
        save.setActionCommand("guardar"+namePanel);
        save.addActionListener(listener);
        add(save);

    }
}