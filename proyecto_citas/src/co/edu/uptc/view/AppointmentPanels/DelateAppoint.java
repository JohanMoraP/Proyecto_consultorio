package co.edu.uptc.view.AppointmentPanels;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;

import co.edu.uptc.model.Appointment;
import co.edu.uptc.view.SearchBarId;
import co.edu.uptc.view.TittlePanel;
import co.edu.uptc.view.UserPanels.PanelUserData;

public class DelateAppoint extends JPanel {
	
	private SearchBarId searchBarId;
	private TittlePanel header;
	private JList<String> listAppoints;

    public DelateAppoint(ActionListener listener) {
        // setPreferredSize(new Dimension(400, 1000));
        initComponents(listener);
    }

    private void initComponents(ActionListener listener) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        header = new TittlePanel();
        header.getTittle().setText("Borrar Cita ");
        header.setPreferredSize(new Dimension(getWidth(), 100));
        add(header);

        searchBarId = new SearchBarId(listener, "DelateAppoint");
        
        add(searchBarId);
        
        listAppoints = new JList<>();
        add(listAppoints);
        
    }

    public String idSearch() {
        return searchBarId.getTextId();
    }
    
	public JList<String> getListAppoints() {
		return listAppoints;
	}

	public void setListAppoints(JList<String> listAppoints) {
		this.listAppoints = listAppoints;
	}


}
