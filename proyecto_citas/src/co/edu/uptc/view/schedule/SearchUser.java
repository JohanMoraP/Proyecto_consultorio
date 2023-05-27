package co.edu.uptc.view.schedule;

import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.uptc.view.GreenButton;
import co.edu.uptc.view.SearchBarId;
import co.edu.uptc.view.TittlePanel;
import co.edu.uptc.view.UserPanels.PanelUserData;

public class SearchUser extends JPanel {

    SearchBarId searchBarId;
    TittlePanel header;
    private PanelUserData panelUser;

    public SearchUser(ActionListener listener) {
        //setPreferredSize(new Dimension(400, 1000));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        searchBarId = new SearchBarId(listener,"Buscar");
        add(searchBarId);

        GreenButton buttonConfirmar= new GreenButton("guardarCita");
        buttonConfirmar.addActionListener(listener);
        buttonConfirmar.setActionCommand("guardarCita");
        add(buttonConfirmar);
    }

    public String idSearch(){
        System.out.println(searchBarId.getTextId());
        return searchBarId.getTextId();
    }

    public void addData(String[] data) {
        panelUser = new PanelUserData();
        panelUser.setNameText(data[0]);
        panelUser.setLastNameText(data[1]);
        panelUser.setAgeText(data[2]);
        panelUser.setNumberPhoneText(data[3]);
        panelUser.setUserText(data[4]);
        panelUser.enableText();
        add(panelUser);

    }

}
