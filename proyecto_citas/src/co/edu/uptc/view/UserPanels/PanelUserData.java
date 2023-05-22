package co.edu.uptc.view.UserPanels;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelUserData extends JPanel {
    private JLabel name;
    private JLabel lastName;
    private JLabel age;
    private JLabel numberPhone;
    private JLabel idUser;
    private JTextField nameText;
    private JTextField lastNameText;
    private JTextField ageText;
    private JTextField numberPhoneText;
    private JTextField idUserText;

    public PanelUserData() {
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

        
        idUser = new JLabel("Identificaciòn");
        idUser.setAlignmentX(Component.RIGHT_ALIGNMENT);
        add(idUser);
        idUserText = new JTextField(12);
        add(idUserText);


    
    }

    public String getNameText() {
        return nameText.getText();
    }

    public void setNameText(String nameText) {
        this.nameText.setText(nameText);
    }

    public String getLastNameText() {
        return lastNameText.getText();
    }

    public void setLastNameText(String lastNameText) {
        this.lastNameText.setText(lastNameText);
    }

    public String getAgeText() {
        return ageText.getText();
    }

    public void setAgeText(String ageText) {
        this.ageText.setText(ageText);
    }


    public String getNumberPhoneText() {
        return numberPhoneText.getText();
    }

    public void setNumberPhoneText(String numberPhoneText) {
        this.numberPhoneText.setText(numberPhoneText);
    }

    public String getidUserText() {
        return idUserText.getText();
    }

    public void setUserText(String userText) {
        this.idUserText.setText(userText);
    }

    public void enableText() {
        this.nameText.setEditable(false);
        this.lastNameText.setEditable(false);
        this.ageText.setEditable(false);
        this.numberPhoneText.setEditable(false);
        this.idUserText.setEditable(false);
    }
}