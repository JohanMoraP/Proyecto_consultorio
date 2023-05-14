package co.edu.uptc.view.AppointmentPanels;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCitaData extends JPanel {
    private JLabel name;
    private JLabel lastName;
    private JLabel age;
    private JLabel day;
    private JLabel numberPnone;
    private JLabel hour;
    private JLabel doctor;
    private JLabel idNumber;
    private JTextField nameText;
    private JTextField lastNameText;
    private JTextField ageText;
    private JTextField dayText;
    private JTextField numberPhoneText;
    private JTextField hourText;
    private JTextField doctorText;
    private JTextField idNUmberText;

    public PanelCitaData() {
        initComponents();

    }

    private void initComponents() {

        setLayout(new GridLayout(5, 4, 15, 30));
        name = new JLabel("Nombre");
        name.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(name);
        nameText = new JTextField(12);
        add(nameText);

        lastName = new JLabel("Apellido");
        lastName.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(lastName);
        lastNameText = new JTextField(12);
        add(lastNameText);

        age = new JLabel("Edad");
        age.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(age);
        ageText = new JTextField(12);
        add(ageText);

        day = new JLabel("Dia");
        day.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(day);
        dayText = new JTextField(12);
        add(dayText);

        numberPnone = new JLabel("Numero de telefono");
        numberPnone.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(numberPnone);
        numberPhoneText = new JTextField(12);
        add(numberPhoneText);

        hour = new JLabel("Hora");
        hour.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(hour);
        hourText = new JTextField(12);
        add(hourText);

        doctor = new JLabel("Doctor");
        doctor.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(doctor);
        doctorText = new JTextField(12);
        add(doctorText);

        idNumber = new JLabel("id Number");
        idNumber.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(idNumber);
        nameText = new JTextField(12);
        add(nameText);

    }

    public JTextField getNameText() {
        return nameText;
    }

    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    public JTextField getLastNameText() {
        return lastNameText;
    }

    public void setLastNameText(JTextField lastNameText) {
        this.lastNameText = lastNameText;
    }

    public JTextField getAgeText() {
        return ageText;
    }

    public void setAgeText(JTextField ageText) {
        this.ageText = ageText;
    }

    public JTextField getDayText() {
        return dayText;
    }

    public void setDayText(JTextField dayText) {
        this.dayText = dayText;
    }

    public JTextField getNumberPhoneText() {
        return numberPhoneText;
    }

    public void setNumberPhoneText(JTextField numberPhoneText) {
        this.numberPhoneText = numberPhoneText;
    }

    public JTextField getHourText() {
        return hourText;
    }

    public void setHourText(JTextField hourText) {
        this.hourText = hourText;
    }

    public JTextField getDoctorText() {
        return doctorText;
    }

    public void setDoctorText(JTextField doctorText) {
        this.doctorText = doctorText;
    }

    public JTextField getIdNUmberText() {
        return idNUmberText;
    }

    public void setIdNUmberText(JTextField idNUmberText) {
        this.idNUmberText = idNUmberText;
    }

}