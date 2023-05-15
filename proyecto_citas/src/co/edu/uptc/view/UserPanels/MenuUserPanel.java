package co.edu.uptc.view.UserPanels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.view.TittlePanel;

public class MenuUserPanel extends JPanel {
    
    JButton btnSearchUser;
    JButton btnCreateUser;
    TittlePanel header;

    public MenuUserPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(30, 30));
        header = new TittlePanel();
        header.getTittle().setText("MODULO USUARIOS");
        header.setPreferredSize(new Dimension(getWidth(), 100));
        add(header,BorderLayout.PAGE_START);
       
        JPanel panelButtons= new JPanel();
    
        btnCreateUser = new JButton();
        ImageIcon imageCreate = new ImageIcon(((new ImageIcon("images/agregarUsuario.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
        btnCreateUser.setIcon(imageCreate);
        btnCreateUser.setBorderPainted(false);
        btnCreateUser.setContentAreaFilled(false);
        btnCreateUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelButtons.add(btnCreateUser);

        btnSearchUser = new JButton();
        ImageIcon imageSearch = new ImageIcon(((new ImageIcon("images/buscarUsuario.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
        btnSearchUser.setIcon(imageSearch);
        btnSearchUser.setBorderPainted(false);
        btnSearchUser.setContentAreaFilled(false);
        btnSearchUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelButtons.add(btnSearchUser);

        add(panelButtons, BorderLayout.CENTER
        );
    }


    
}
