package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel {

    private TittlePanel welcome;
    private JLabel icon;
    private ImageIcon imageMenu;

    public Home() {
        // setBackground(Color.orange);
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        welcome = new TittlePanel();
        welcome.getTittle().setText("Bienvenido a DentalMaster");
        welcome.setFont(new Font("Product Sans", Font.PLAIN, 30));
        add(welcome, BorderLayout.NORTH);

        icon = new JLabel();
        imageMenu = new ImageIcon(((new ImageIcon("images/hilo-dental.png")).getImage()).getScaledInstance(250, 250,
                java.awt.Image.SCALE_SMOOTH));
        icon.setIcon(imageMenu);
        add(icon, BorderLayout.CENTER);

    }
}
