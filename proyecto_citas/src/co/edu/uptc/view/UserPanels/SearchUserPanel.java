package co.edu.uptc.view.UserPanels;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.uptc.view.SearchBarId;
import co.edu.uptc.view.TittlePanel;

public class SearchUserPanel extends JPanel {

	private SearchBarId searchBarId;
	private TittlePanel header;
    private PanelUserData panelUser;

    public SearchUserPanel(ActionListener listener) {
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("BUSCAR USUARIO");
        header.setPreferredSize(new Dimension(getWidth(), 100));
        add(header);

        searchBarId = new SearchBarId(listener, "User");
        add(searchBarId);
    }

    public String idSearch() {
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
