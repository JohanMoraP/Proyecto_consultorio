package co.edu.uptc.view.schedule;

import javax.swing.*;
import com.toedter.calendar.JCalendar;
import co.edu.uptc.model.Doctor;
import co.edu.uptc.view.GreenButton;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ScheduleButtons extends JPanel implements ItemListener {
    private JCalendar calendar;
    private JComboBox<String> doctors;
    private JComboBox<String> speciality;
    private JComboBox<String> hour;
    private JPanel panelButtons1;
    private JPanel panelButtons2;
    private JPanel panelButtons3;
    public ActionListener listenerP;
    public GreenButton buttonSpeciality;
    private GreenButton buttonDoctor;
    public Calendar cal;
    public String hourSelected;

    public ScheduleButtons(ActionListener listener, ArrayList<String> specialityList) {
        cal = cal.getInstance();
        listenerP = listener;
        initComponents();
        createButtons(specialityList, listener);
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        calendar = new JCalendar();
        calendar.setDecorationBackgroundColor(new Color(41, 99, 99, 71));
        calendar.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 15));
        add(calendar);
        calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("calendar")) {

                    cal = (GregorianCalendar) evt.getNewValue();
                    System.out.println(cal.getTime());
                }
            }
        });

    }

    private void createButtons(ArrayList<String> specialityList, ActionListener listener) {
        panelButtons1 = new JPanel();
        panelButtons1.setLayout(new BoxLayout(panelButtons1, BoxLayout.X_AXIS));
        panelButtons1.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 15));
        JLabel label3 = new JLabel();
        label3.setText("ESPECIALIDAD");
        label3.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 8));
        panelButtons1.add(label3);
        speciality = new JComboBox<String>();
        speciality.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 8));
        for (String specialityItem : specialityList) {
            speciality.addItem(specialityItem);
        }
        panelButtons1.add(speciality);

        buttonSpeciality = new GreenButton("Consultar");
        buttonSpeciality.setBounds(5, 10, 10, 5);
        buttonSpeciality.setActionCommand("doctors");
        buttonSpeciality.addActionListener(listener);
        panelButtons1.add(buttonSpeciality);

        add(panelButtons1);

        panelButtons2 = new JPanel();
        panelButtons2.setLayout(new BoxLayout(panelButtons2, BoxLayout.X_AXIS));
        panelButtons2.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 15));
        JLabel label1 = new JLabel();
        label1.setText("DOCTOR");
        label1.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 8));
        panelButtons2.add(label1);
        doctors = new JComboBox<String>();
        doctors.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 8));
        panelButtons2.add(doctors);

        buttonDoctor = new GreenButton("Consultar");
        buttonDoctor.setBounds(5, 10, 10, 5);
        buttonDoctor.setActionCommand("hours");
        buttonDoctor.addActionListener(listener);
        panelButtons2.add(buttonDoctor);

        add(panelButtons2);

        panelButtons3 = new JPanel();
        panelButtons3.setLayout(new BoxLayout(panelButtons3, BoxLayout.X_AXIS));
        panelButtons3.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 15));
        JLabel label = new JLabel();
        label.setText("HORARIO DISPONIBLE");
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 8));
        panelButtons3.add(label);
        hour = new JComboBox<String>();
        hour.addItemListener(this);
        hour.setBorder(BorderFactory.createEmptyBorder(0, 0, 8, 8));
        panelButtons3.add(hour);
        add(panelButtons3);
    }

    public void addDoctorsDisponibility(ArrayList<Doctor> doctorsDisponibility, ActionListener listener) {
        for (Doctor doctor : doctorsDisponibility) {
            doctors.addItem(doctor.getName() + " " + doctor.getLastName());
        }
    }

    public void addHoursDisponibility(ArrayList<String> listHourDisponibility) {
        for (String listHour : listHourDisponibility) {
            hour.addItem(listHour);
        }
    }

    public String getDoctors() {
        return (String) doctors.getSelectedItem();
    }

    public String getDate() {
        Date date = cal.getTime();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        String date1 = format1.format(date);
        return date1;
    }

    public void setDoctors(JComboBox<String> doctors) {
        this.doctors = doctors;
    }

    public String getSpeciality() {
        return (String) speciality.getSelectedItem();
    }

    public void setSpeciality(JComboBox<String> speciality) {
        this.speciality = speciality;
    }

    public String getHourSelected() {
        return hourSelected;
    }

    public void setHour(JComboBox<String> hour) {
        this.hour = hour;
    }

    public void removeItemsDoctors() {
        doctors.removeAllItems();
    }

    public void removeItemsHours() {
        hour.removeAllItems();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == hour) {
            hourSelected = (String) hour.getSelectedItem();
        }
    }

}
