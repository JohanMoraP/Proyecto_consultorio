package co.edu.uptc.view.DoctorPanels;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.uptc.view.SearchBarId;
import co.edu.uptc.view.TittlePanel;

public class SearchDoctorPanel extends JPanel {

    SearchBarId searchBarId;
    TittlePanel header;
    PanelDoctorData panelDoctorData;

    public SearchDoctorPanel(ActionListener listener) {
        setPreferredSize(new Dimension(400, 1000));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("BUSCAR MEDICO");
        header.setPreferredSize(new Dimension(getWidth(), 100));
        add(header);

        searchBarId = new SearchBarId(listener,"Doctor");
        add(searchBarId);
    }

    public String idSearch(){
        return searchBarId.getTextIdUser();
    }

    public void addData(String[] data) {
        panelDoctorData = new PanelDoctorData();
        panelDoctorData.setNameText(data[0]);
        panelDoctorData.setLastNameText(data[1]);
        panelDoctorData.setAgeText(data[2]);
        panelDoctorData.setNumberPhoneText(data[3]);
        panelDoctorData.setDoctorText(data[4]);
        panelDoctorData.setSpecialityText(data[5]);
        panelDoctorData.enableText();
        add(panelDoctorData);

    }

}
