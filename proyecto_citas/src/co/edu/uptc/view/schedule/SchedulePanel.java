package co.edu.uptc.view.schedule;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import co.edu.uptc.model.Doctor;
import co.edu.uptc.presenter.App;
import co.edu.uptc.view.GreenButton;
import co.edu.uptc.view.TittlePanel;

public class SchedulePanel extends JPanel {
    private ScheduleButtons horario;
    private TittlePanel tittle;
    private GreenButton asign;
    public static String specialitySearch;
    public static String sendDoctorSelected;
    public ArrayList<Doctor> doctorsListDisponibility;

    public SchedulePanel(ActionListener listener, ArrayList<String> specialityList) {
        initComponents(listener, specialityList);
    }

    private void initComponents(ActionListener listener, ArrayList<String> specialityList) {
        this.setLayout(new BorderLayout());
        tittle = new TittlePanel();
        tittle.getTittle().setText("HORARIO DE CITAS");
        add(tittle, BorderLayout.NORTH);

        horario = new ScheduleButtons(listener, specialityList);
        add(horario, BorderLayout.CENTER);
        
        JPanel panel= new JPanel();
        asign = new GreenButton("Asignar");
        asign.setBounds(5, 10, 10, 5);
        asign.setActionCommand("asignar");
        asign.addActionListener(listener);
        panel.add(asign);
        add(panel, BorderLayout.SOUTH);
    }

    public void addDoctorsDisponibility(ArrayList<Doctor> doctorsDisponibility, ActionListener listener){
        horario.addDoctorsDisponibility(doctorsDisponibility, listener);
    }


    public String getSpecialitySearch() {
        return horario.getSpeciality();
    }

    public String getSendDoctorSelected() {
        return horario.getDoctors();
    }

    public String getSendHourSelected() {
        return horario.getHourSelected();
    }
    public String getDateAppointment(){
        return horario.getDate();
    }


    public void addHoursDisponibility(ArrayList<String> listHourDisponibility) {
        System.out.println(listHourDisponibility.size());
        horario.addHoursDisponibility(listHourDisponibility);
    }

    public void cleanComboDoctors() {
        horario.removeItemsDoctors();
    }

    public void cleanComboHours() {
        horario.removeItemsHours();
    }

}
