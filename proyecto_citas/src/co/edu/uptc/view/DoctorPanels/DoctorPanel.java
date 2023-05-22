package co.edu.uptc.view.DoctorPanels;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import co.edu.uptc.view.TittlePanel;
import co.edu.uptc.view.AppointmentPanels.AppointmentButtons;

public class DoctorPanel extends JPanel {

    public TittlePanel header;
    public PanelDoctorData panelDoctor;
    public AppointmentButtons buttons;

    public DoctorPanel(ActionListener listener) {

        setBackground(Color.white);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("CREAR MEDICO");
        add(header);
        panelDoctor = new PanelDoctorData();
        panelDoctor.setBorder(
                BorderFactory.createEmptyBorder(0, (int) (this.getWidth() * 0.4), 0, (int) (this.getWidth() * 0.4)));

        add(panelDoctor);

        buttons = new AppointmentButtons(listener, "Doctor");
        add(buttons);
    }


    public String[] sendDataFormDoctor(){
        String[] data ={panelDoctor.getNameText(), panelDoctor.getLastNameText(),
             panelDoctor.getAgeText(), panelDoctor.getNumberPhoneText(),
             panelDoctor.getidDoctorText(), panelDoctor.getSpecialityText()};
        return data;
    }

    public void cleanForm() {
        panelDoctor.setNameText("");
        panelDoctor.setLastNameText("");
        panelDoctor.setAgeText("");
        panelDoctor.setNumberPhoneText("");
        panelDoctor.setDoctorText("");
        panelDoctor.setSpecialityText("");
    }

}
