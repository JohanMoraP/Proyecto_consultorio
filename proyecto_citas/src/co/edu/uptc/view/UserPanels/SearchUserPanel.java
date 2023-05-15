package co.edu.uptc.view.UserPanels;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import co.edu.uptc.view.TittlePanel;
import co.edu.uptc.view.AppointmentPanels.SearchBarId;

public class SearchUserPanel  extends JPanel{

    SearchBarId searchBarId;
    TittlePanel header;

    public SearchUserPanel() {
        setPreferredSize(new Dimension(400, 1000));
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("BUSCAR USUARIO");
        header.setPreferredSize(new Dimension(getWidth(), 100));
        add(header);

        searchBarId= new SearchBarId();
        add(searchBarId);
    }
    
}
