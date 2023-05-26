package co.edu.uptc.view.DoctorPanels;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import co.edu.uptc.view.TittlePanel;
import co.edu.uptc.view.AppointmentPanels.AppointmentButtons;

public class DoctorPanel extends JPanel {

	private TittlePanel header;
	private PanelDoctorData panelDoctor;
	private AppointmentButtons buttons;

    public DoctorPanel(ActionListener listener, ArrayList<String> specialityList) {

        setBackground(Color.white);
        initComponents(listener, specialityList);
    }

    private void initComponents(ActionListener listener, ArrayList<String> specialityList) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("CREAR MEDICO");
        add(header);
        panelDoctor = new PanelDoctorData(specialityList);
        panelDoctor.setBorder(
                BorderFactory.createEmptyBorder(0, (int) (this.getWidth() * 0.4), 0, (int) (this.getWidth() * 0.4)));

        add(panelDoctor);

        buttons = new AppointmentButtons(listener, "Doctor");
        add(buttons);
    }

    public String[] sendDataFormDoctor() {
        String[] data = { panelDoctor.getNameText().getText(), panelDoctor.getLastNameText().getText(),
                panelDoctor.getAgeText().getText(), panelDoctor.getNumberPhoneText().getText(),
                panelDoctor.getIdDoctorText().getText(), panelDoctor.getSpecialityText().getSelectedItem().toString() };
        return data;
    }

    public void cleanForm() {
        panelDoctor.getNameText().setText("");
        panelDoctor.getLastNameText().setText("");
        panelDoctor.getAgeText().setText("");
        ;
        panelDoctor.getNumberPhoneText().setText("");
        panelDoctor.getIdDoctorText().setText("");
        panelDoctor.getSpecialityText().removeAllItems();
    }

}
