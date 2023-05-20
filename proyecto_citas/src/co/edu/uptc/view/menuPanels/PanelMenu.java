package co.edu.uptc.view.menuPanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelMenu extends JPanel {
    private JButton btnAppoint;
    private JButton btnDoctor;
    private JButton btnUsers;
    private JLabel labelSystem;
    private JLabel labelMenu;
    private JButton btnHome;

    public PanelMenu(ActionListener listener) {
        setPreferredSize(new Dimension(200, 600));
        setBackground(new Color(41, 99, 99));
        initComponents(listener);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 15));

    }

    private void initComponents(ActionListener listener) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        btnHome = new JButton();
        ImageIcon imageMenu = new ImageIcon(
                ((new ImageIcon("images/cita.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        btnHome.setIcon(imageMenu);
        btnHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHome.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 15));
        btnHome.setBackground(null);
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.addActionListener(listener);
        btnHome.setActionCommand("home");
        add(btnHome);

        labelSystem = new JLabel("NOMBRE DEL SISTEMA");
        labelSystem.setForeground(Color.white);
        labelSystem.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelSystem.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 15));
        add(labelSystem);

        labelMenu = new JLabel("MENU");
        labelMenu.setForeground(Color.white);
        labelMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(labelMenu);

        btnAppoint = new JButton();
        ImageIcon imageApp = new ImageIcon(
                ((new ImageIcon("images/cita.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        btnAppoint.setIcon(imageApp);
        btnAppoint.setText("CITAS");
        btnAppoint.setForeground(Color.white);
        btnAppoint.setBorderPainted(false);
        btnAppoint.setContentAreaFilled(false);
        btnAppoint.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAppoint.addActionListener(listener);
        btnAppoint.setActionCommand("citas");
        add(btnAppoint);

        btnDoctor = new JButton();
        ImageIcon imageDoctor = new ImageIcon(((new ImageIcon("images/doctores.png")).getImage()).getScaledInstance(50,
                50, java.awt.Image.SCALE_SMOOTH));
        btnDoctor.setIcon(imageDoctor);
        btnDoctor.setText("DOCTOR");
        btnDoctor.setForeground(Color.white);
        btnDoctor.setBorderPainted(false);
        btnDoctor.setContentAreaFilled(false);
        btnDoctor.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnDoctor.addActionListener(listener);
        btnDoctor.setActionCommand("doctor");
        add(btnDoctor);

        btnUsers = new JButton();
        ImageIcon imageUser = new ImageIcon(((new ImageIcon("images/usuarios.png")).getImage()).getScaledInstance(50,
                50, java.awt.Image.SCALE_SMOOTH));
        btnUsers.setIcon(imageUser);
        btnUsers.setText("USUARIO");
        btnUsers.setForeground(Color.white);
        btnUsers.setBorderPainted(false);
        btnUsers.setContentAreaFilled(false);
        btnUsers.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnUsers.addActionListener(listener);
        btnUsers.setActionCommand("usuario");
        add(btnUsers);
    }

}