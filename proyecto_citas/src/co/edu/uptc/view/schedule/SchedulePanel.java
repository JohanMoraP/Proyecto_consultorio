package co.edu.uptc.view.schedule;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import co.edu.uptc.view.GreenButton;
import co.edu.uptc.view.TittlePanel;

public class SchedulePanel extends JPanel {
    private ScheduleTable horario;
    private TittlePanel tittle;
    private GreenButton asign;

    public SchedulePanel() {
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());
        tittle = new TittlePanel();
        tittle.getTittle().setText("HORARIO DE CITAS");
        add(tittle, BorderLayout.NORTH);

        horario = new ScheduleTable();
        add(horario, BorderLayout.CENTER);

        asign = new GreenButton("Asignar");
        asign.setBounds(5, 10, 10, 5);
        asign.setActionCommand("asignar");
        add(asign, BorderLayout.SOUTH);
    }
}