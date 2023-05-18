package co.edu.uptc.view.AppointmentPanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.uptc.view.SearchBarId;
import co.edu.uptc.view.TittlePanel;

public class AppointmentPanel extends JPanel {

    private TittlePanel header;
    private SearchBarId searchBar;
    private PanelCitaData panelCitas;
    private AppointmentButtons buttons;

    public AppointmentPanel() {
        setBackground(Color.white);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("ASIGNAR CITA");
        header.setPreferredSize(new Dimension(100, 70));
        add(header);

        searchBar = new SearchBarId();
        add(searchBar);

        panelCitas = new PanelCitaData();
        panelCitas.setBorder(
                BorderFactory.createEmptyBorder(0, (int) (this.getWidth() * 0.4), 0, (int) (this.getWidth() * 0.4)));

        add(panelCitas);

        buttons = new AppointmentButtons();
        add(buttons);
    }

}
