package co.edu.uptc.view.DoctorPanels;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDoctorData extends JPanel {
    private JLabel name;
    private JLabel lastName;
    private JLabel age;
    private JLabel numberPhone;
    private JLabel idDoctor;
    private JLabel specialty;
    private JTextField nameText;
    private JTextField lastNameText;
    private JTextField ageText;
    private JTextField numberPhoneText;
    private JTextField specialityText;
    private JTextField idDoctorText;

    public PanelDoctorData() {
        setPreferredSize(new Dimension(600,85));
        initComponents();

    }

    private void initComponents() {

        setLayout(new GridLayout(3, 4, 15, 30));
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

        numberPhone = new JLabel("Numero de telefono");
        numberPhone.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(numberPhone);
        numberPhoneText = new JTextField(12);
        add(numberPhoneText);

        
        idDoctor = new JLabel("Identificaciòn");
        idDoctor.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(idDoctor);
        idDoctorText = new JTextField(12);
        add(idDoctorText);


        specialty = new JLabel("Especialidad");
        specialty.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(specialty);
        specialityText = new JTextField(12);
        add(specialityText);

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


    public JTextField getNumberPhoneText() {
        return numberPhoneText;
    }

    public void setNumberPhoneText(JTextField numberPhoneText) {
        this.numberPhoneText = numberPhoneText;
    }

    public JTextField getidDoctorText() {
        return idDoctorText;
    }

    public void setDoctorText(JTextField doctorText) {
        this.idDoctorText = doctorText;
    }

    public JTextField getSpecialityText() {
        return specialityText;
    }

    public void setSpecialityText(JTextField specialityText) {
        this.specialityText = specialityText;
    }

}