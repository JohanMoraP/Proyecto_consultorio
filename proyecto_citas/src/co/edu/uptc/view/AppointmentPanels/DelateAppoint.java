package co.edu.uptc.view.AppointmentPanels;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;

import co.edu.uptc.model.Appointment;
import co.edu.uptc.presenter.App;
import co.edu.uptc.view.SearchBarId;
import co.edu.uptc.view.TittlePanel;

public class DelateAppoint extends JPanel {
	
	private SearchBarId searchBarId;
	private TittlePanel header;
	private JList<String> listAppoints;
    private JTableData tablePanel;

    public DelateAppoint(ActionListener listener) {
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
        
        /*listAppoints = new JList<>();
        add(listAppoints);*/
        
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

    public void addDataTable(ArrayList<Appointment> searchAppointForUser) {
        System.out.println(searchAppointForUser.size());
        tablePanel= new JTableData();
        tablePanel.addElementToTable(searchAppointForUser);
        add(tablePanel);
       
    }
    public ArrayList<Appointment> appointmentList(){
		return tablePanel.getListAppointement();
    	
    }



}
