package co.edu.uptc.view.DoctorPanels;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import co.edu.uptc.view.TittlePanel;

public class MenuDoctorPanel extends JPanel {

    private JButton btnSearchDoctor;
    private JButton btnCreateDoctor;
    private TittlePanel header;

    public MenuDoctorPanel(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setLayout(new BorderLayout(30, 30));
        header = new TittlePanel();
        header.getTittle().setText("MODULO MEDICOS");
        header.setPreferredSize(new Dimension(getWidth(), 100));
        add(header, BorderLayout.PAGE_START);

        JPanel panelButtons = new JPanel();

        btnCreateDoctor = new JButton();
        ImageIcon imageCreate = new ImageIcon(((new ImageIcon("images/doctor.png")).getImage()).getScaledInstance(150,
                150, java.awt.Image.SCALE_SMOOTH));
        btnCreateDoctor.setIcon(imageCreate);
        btnCreateDoctor.setBorderPainted(false);
        btnCreateDoctor.setContentAreaFilled(false);
        btnCreateDoctor.setText("Crear Doctor");
        btnCreateDoctor.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCreateDoctor.addActionListener(listener);
        btnCreateDoctor.setActionCommand("createDoctor");
        panelButtons.add(btnCreateDoctor);

        btnSearchDoctor = new JButton();
        ImageIcon imageSearch = new ImageIcon(((new ImageIcon("images/doctorBuscar.png")).getImage())
                .getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));
        btnSearchDoctor.setIcon(imageSearch);
        btnSearchDoctor.setBorderPainted(false);
        btnSearchDoctor.setContentAreaFilled(false);
        btnSearchDoctor.setText("Buscar Doctor");
        btnSearchDoctor.addActionListener(listener);
        btnSearchDoctor.setActionCommand("serachDoctor");
        btnSearchDoctor.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelButtons.add(btnSearchDoctor);

        add(panelButtons, BorderLayout.CENTER);
    }

}
