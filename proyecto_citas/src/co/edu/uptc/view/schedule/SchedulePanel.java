package co.edu.uptc.view.schedule;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import co.edu.uptc.model.Doctor;
import co.edu.uptc.view.GreenButton;
import co.edu.uptc.view.TittlePanel;

public class SchedulePanel extends JPanel {
    private ScheduleCalendar horario;
    private TittlePanel tittle;
    private GreenButton asign;
    private ScheduleInfoSelect info;

    public SchedulePanel(ActionListener listener, ArrayList<Doctor> doctors) {
        initComponents(listener, doctors);
    }

    private void initComponents(ActionListener listener, ArrayList<Doctor> doctors) {
        this.setLayout(new BorderLayout());
        tittle = new TittlePanel();
        tittle.getTittle().setText("HORARIO DE CITAS");
        add(tittle, BorderLayout.NORTH);

        horario = new ScheduleCalendar();
        add(horario, BorderLayout.CENTER);

        info = new ScheduleInfoSelect(doctors);
        add(info, BorderLayout.EAST);
        asign = new GreenButton("Asignar");
        asign.setBounds(5, 10, 10, 5);
        asign.setActionCommand("asignar");
        asign.addActionListener(listener);
        add(asign, BorderLayout.SOUTH);
    }
}
