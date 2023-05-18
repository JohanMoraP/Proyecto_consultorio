package co.edu.uptc.view.DoctorPanels;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.uptc.view.TittlePanel;
import co.edu.uptc.view.AppointmentPanels.AppointmentButtons;

public class DoctorPanel extends JPanel {

    private TittlePanel header;
    private PanelDoctorData panelDoctor;
    private AppointmentButtons buttons;

    public DoctorPanel() {
        setBackground(Color.white);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("CREAR MEDICO");
        add(header);

        panelDoctor = new PanelDoctorData();
        panelDoctor.setBorder(
                BorderFactory.createEmptyBorder(0, (int) (this.getWidth() * 0.4), 0, (int) (this.getWidth() * 0.4)));

        add(panelDoctor);

        buttons = new AppointmentButtons();
        add(buttons);
    }

}
