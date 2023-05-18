package co.edu.uptc.view.menuPanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
    private JLabel labelImage;

    public PanelMenu() {
        setPreferredSize(new Dimension(200, 600));
        setBackground(new Color(41, 99, 99));
        initComponents();

    }

    private void initComponents() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        labelImage = new JLabel();
        ImageIcon imageMenu = new ImageIcon(
                ((new ImageIcon("images/cita.png")).getImage()).getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
        labelImage.setIcon(imageMenu);
        labelImage.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(labelImage);

        labelSystem = new JLabel("NOMBRE DEL SISTEMA");
        labelSystem.setForeground(Color.white);
        labelSystem.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        add(btnUsers);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        PanelMenu menu = new PanelMenu();
        frame.add(menu);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}