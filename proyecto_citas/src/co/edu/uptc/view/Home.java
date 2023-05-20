package co.edu.uptc.view;

import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel {

    private JLabel welcome;
    private JLabel icon;
    private ImageIcon imageMenu;

    public Home() {
        // TODO Auto-generated constructor stub
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        icon = new JLabel();
        imageMenu = new ImageIcon(((new ImageIcon("images/cita.png")).getImage()).getScaledInstance(250, 250,
                java.awt.Image.SCALE_SMOOTH));
        icon.setIcon(imageMenu);
        add(icon);

        welcome = new JLabel("Bienvenido");
        welcome.setFont(new Font("Product Sans", Font.PLAIN, 30));
        ;
        add(welcome);
    }
}
