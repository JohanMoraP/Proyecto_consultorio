package co.edu.uptc.view.AppointmentPanels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.view.TittlePanel;

public class MenuAppointment extends JPanel{
	private JButton btnNewAppoint;
    private JButton btnDelateAppoint;
    private TittlePanel header;

    public MenuAppointment(ActionListener listener) {
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {
        setLayout(new BorderLayout(30, 30));
        header = new TittlePanel();
        header.getTittle().setText("MODULO MEDICOS");
        header.setPreferredSize(new Dimension(getWidth(), 100));
        add(header, BorderLayout.PAGE_START);

        JPanel panelButtons = new JPanel();


        btnNewAppoint = new JButton();
        ImageIcon imageSearch = new ImageIcon(((new ImageIcon("images/addCita.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
        btnNewAppoint.setIcon(imageSearch);
        btnNewAppoint.setBorderPainted(false);
        btnNewAppoint.setContentAreaFilled(false);
        btnNewAppoint.setText("Nueva Cita");
        btnNewAppoint.addActionListener(listener);
        btnNewAppoint.setActionCommand("newAppoint");
        btnNewAppoint.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelButtons.add(btnNewAppoint);
        add(panelButtons, BorderLayout.CENTER);
        
        btnDelateAppoint = new JButton();
        ImageIcon imageCreate = new ImageIcon(((new ImageIcon("images/eliminar.png")).getImage()).getScaledInstance(150,150, java.awt.Image.SCALE_SMOOTH));
        btnDelateAppoint.setIcon(imageCreate);
        btnDelateAppoint.setBorderPainted(false);
        btnDelateAppoint.setContentAreaFilled(false);
        btnDelateAppoint.setText("Borrar Cita");
        btnDelateAppoint.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDelateAppoint.addActionListener(listener);
        btnDelateAppoint.setActionCommand("delateAppoint");
        panelButtons.add(btnDelateAppoint);
    }

}
