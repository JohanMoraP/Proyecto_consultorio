package co.edu.uptc.view.UserPanels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import co.edu.uptc.view.TittlePanel;

public class MenuUserPanel extends JPanel {
    
    JButton btnSearchUser;
    JButton btnCreateUser;
    TittlePanel header;

    public MenuUserPanel(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setLayout(new BorderLayout(30, 30));
        header = new TittlePanel();
        header.getTittle().setText("MODULO USUARIOS");
        header.setPreferredSize(new Dimension(getWidth(), 100));
        add(header,BorderLayout.PAGE_START);
       
        JPanel panelButtons= new JPanel();
    
        btnCreateUser = new JButton("Crear Usuario");
        ImageIcon imageCreate = new ImageIcon(((new ImageIcon("images/agregarUsuario.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
        btnCreateUser.setIcon(imageCreate);
        btnCreateUser.setBorderPainted(false);
        btnCreateUser.setContentAreaFilled(false);
        btnCreateUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCreateUser.setActionCommand("createUser");
        btnCreateUser.addActionListener(listener);
        panelButtons.add(btnCreateUser);

        btnSearchUser = new JButton("Buscar Usuario");
        ImageIcon imageSearch = new ImageIcon(((new ImageIcon("images/buscarUsuario.png")).getImage()).getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
        btnSearchUser.setIcon(imageSearch);
        btnSearchUser.setBorderPainted(false);
        btnSearchUser.setContentAreaFilled(false);
        btnSearchUser.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSearchUser.setActionCommand("searchUser");
        btnSearchUser.addActionListener(listener);
        panelButtons.add(btnSearchUser);

        add(panelButtons, BorderLayout.CENTER
        );
    }


    
}
