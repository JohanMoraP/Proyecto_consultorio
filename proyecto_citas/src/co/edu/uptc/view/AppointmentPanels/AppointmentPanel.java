package co.edu.uptc.view.AppointmentPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Action;
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

    public AppointmentPanel(ActionListener listener) {
        setBackground(Color.white);
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("ASIGNAR CITA");
        header.setPreferredSize(new Dimension(100, 70));
        add(header);

        searchBar = new SearchBarId(listener,"Citas");
        add(searchBar);

        panelCitas = new PanelCitaData();
        panelCitas.setBorder(
                BorderFactory.createEmptyBorder(0, (int) (this.getWidth() * 0.4), 0, (int) (this.getWidth() * 0.4)));

        add(panelCitas);

        buttons = new AppointmentButtons(listener,"Citas");
        add(buttons);
    }

}
