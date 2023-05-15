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

    public JTextField getidUserText() {
        return idUserText;
    }

    public void setUserText(JTextField userText) {
        this.idUserText = userText;
    }
}