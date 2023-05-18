package co.edu.uptc.view.DoctorPanels;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import co.edu.uptc.view.SearchBarId;
import co.edu.uptc.view.TittlePanel;

public class SearchDoctorPanel extends JPanel {

    SearchBarId searchBarId;
    TittlePanel header;

    public SearchDoctorPanel() {
        setPreferredSize(new Dimension(400, 1000));
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("BUSCAR MEDICO");
        header.setPreferredSize(new Dimension(getWidth(), 100));
        add(header);

        searchBarId = new SearchBarId();
        add(searchBarId);
    }

}
