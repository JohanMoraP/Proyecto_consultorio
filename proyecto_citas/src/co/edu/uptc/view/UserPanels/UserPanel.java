package co.edu.uptc.view.UserPanels;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import co.edu.uptc.view.TittlePanel;
import co.edu.uptc.view.AppointmentPanels.AppointmentButtons;

public class UserPanel extends JPanel {

    private TittlePanel header;
    private PanelUserData panelUser;
    private AppointmentButtons buttons;

    public UserPanel(ActionListener listener) {
        setBackground(Color.white);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("CREAR USUARIO");
        add(header);

        panelUser = new PanelUserData();
        panelUser.setBorder(
                BorderFactory.createEmptyBorder(0, (int) (this.getWidth() * 0.4), 0, (int) (this.getWidth() * 0.4)));

        add(panelUser);

        buttons = new AppointmentButtons(listener,"User");
        add(buttons);
    }
    
    public String[] sendDataFormUser(){
        String[] data ={panelUser.getNameText(), panelUser.getLastNameText(),
            panelUser.getAgeText(), panelUser.getNumberPhoneText(),
            panelUser.getidUserText()};
        return data;
    }

    public void cleanForm() {
        panelUser.setNameText("");
        panelUser.setLastNameText("");
        panelUser.setAgeText("");
        panelUser.setUserText("");
        panelUser.setNumberPhoneText("");
    }
}
