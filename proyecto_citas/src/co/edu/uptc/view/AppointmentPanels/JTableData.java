package co.edu.uptc.view.AppointmentPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import co.edu.uptc.model.Appointment;
import co.edu.uptc.view.GreenButton;

public class JTableData extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements;
	private String[] headers;
	private JTable jtElements;
	private JScrollPane jsTable;

	public JTableData() {
		this.headers = new String[] { "idCita", "Doctor", "Paciente", "Fecha", "Hora"," "};
		initComponents();
	}

	private void initComponents() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBackground(Color.decode("#30373D"));
		dtmElements = new DefaultTableModel();
		dtmElements.setColumnIdentifiers(headers);
		jtElements = new JTable();
		jtElements.setModel(dtmElements);
		jtElements.getTableHeader().setResizingAllowed(false);
		jtElements.getTableHeader().setReorderingAllowed(false);
		//jtElements.getTableHeader().setPreferredSize(new Dimension(0, 60));
		jtElements.getTableHeader().setForeground(Color.black);
		jtElements.setBackground(Color.WHITE);
		jtElements.setFillsViewportHeight(true);
		jtElements.setRowHeight(50);
		jtElements.setBorder(null);
		jsTable = new JScrollPane(jtElements, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsTable.setForeground(Color.RED);
		jsTable.setBorder(null);
		jsTable.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(jsTable, BorderLayout.PAGE_END);
		this.setBorder(null);

	}

	public DefaultTableModel getDtmElements() {
		return dtmElements;
	}

	public void setDtmElements(DefaultTableModel dtmElements) {
		this.dtmElements = dtmElements;
	}

	public void addElementToTable(ArrayList<Appointment> listAppointementUser) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Object[] column= new String[6];

        for (int i = 0; i < listAppointementUser.size(); i++) {
            column[0]= ""+listAppointementUser.get(i).getIdCita();
            column[1]= (""+(listAppointementUser.get(i).getDoctor().getName()+" "+listAppointementUser.get(i).getDoctor().getLastName()));
            column[2]= ""+(listAppointementUser.get(i).getPatient().getName()+" "+listAppointementUser.get(i).getPatient().getLastName());
            column[3]= ""+formato.format(listAppointementUser.get(i).getDateAppoint());
            column[4]= ""+listAppointementUser.get(i).getHour();
			column[5]= "boton cancelar";
			dtmElements.addRow(column);
		}
	}

	public void cleanRowsTable() {
		dtmElements.setNumRows(0);
	}
}