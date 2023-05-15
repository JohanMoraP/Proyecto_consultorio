package co.edu.uptc.view.UserPanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.uptc.view.TittlePanel;
import co.edu.uptc.view.AppointmentPanels.AppointmentButtons;

public class UserPanel extends JPanel {

    private TittlePanel header;
    private PanelUserData panelDoctor;
    private AppointmentButtons buttons;

    public UserPanel() {
        setBackground(Color.white);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("CREAR USUARIO");
        add(header);

        panelDoctor = new PanelUserData();
        panelDoctor.setBorder(
                BorderFactory.createEmptyBorder(0, (int) (this.getWidth() * 0.4), 0, (int) (this.getWidth() * 0.4)));

        add(panelDoctor);

        buttons = new AppointmentButtons();
        add(buttons);
    }

}
