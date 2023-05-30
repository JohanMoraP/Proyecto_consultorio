package co.edu.uptc.view.AppointmentPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.junit.internal.builders.JUnit3Builder;

import java.awt.event.ActionEvent;

import co.edu.uptc.model.Appointment;

public class JTableData extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements;
	private String[] headers;
	private JTable jtElements;
	private JScrollPane jsTable;
	private ArrayList<Appointment> listAppointement;
	private int rowDelete;
	
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
//		jtElements.setEnabled(false);
		jtElements.setBackground(Color.WHITE);
		jtElements.setFillsViewportHeight(true);
		jtElements.setRowHeight(50);
		jtElements.setBorder(null);
		jtElements.setDefaultEditor(Object.class, null);
		jtElements.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
		jsTable = new JScrollPane(jtElements, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jtElements.addMouseListener(this);
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

	public int getRowDelete() {
		return rowDelete;
	}

	public void setRowDelete(int rowDelete) {
		this.rowDelete = rowDelete;
	}

	public void addElementToTable(ArrayList<Appointment> listAppointementUser) {
	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    for (int i = 0; i < listAppointementUser.size(); i++) {
	        Appointment appointment = listAppointementUser.get(i);
	        Object[] column = new Object[6];
	        column[0] = "" + appointment.getIdCita();
	        column[1] = appointment.getDoctor().getName() + " " + appointment.getDoctor().getLastName();
	        column[2] = appointment.getPatient().getName() + " " + appointment.getPatient().getLastName();
	        column[3] = formato.format(appointment.getDateAppoint());
	        column[4] = appointment.getHour();

	        JButton cancelButton = new JButton("Cancelar Cita");
	        jtElements.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
	        column[5] = cancelButton;
	        listAppointement = listAppointementUser;
	        dtmElements.addRow(column);
	    }
	}



	
	private void updateTable() {
	    dtmElements.setRowCount(0);

	    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	    for (Appointment appointment : listAppointement) {
	        Object[] column = new Object[6];
	        column[0] = "" + appointment.getIdCita();
	        column[1] = appointment.getDoctor().getName() + " " + appointment.getDoctor().getLastName();
	        column[2] = appointment.getPatient().getName() + " " + appointment.getPatient().getLastName();
	        column[3] = formato.format(appointment.getDateAppoint());
	        column[4] = appointment.getHour();

	        JButton cancelButton = new JButton("Cancelar cita");
	        cancelButton.addMouseListener(this);
	        column[5] = cancelButton;

	        dtmElements.addRow(column);
	    }
	}


	public void cleanRowsTable() {
		dtmElements.setRowCount(0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	    int row = e.getY()/jtElements.getRowHeight();
		int col= jtElements.getColumnModel().getColumnIndexAtX(e.getX());
	    if (row < jtElements.getRowCount() && row >= 0 && col< jtElements.getColumnCount() && col>=0){
           Object value = jtElements.getValueAt(row, col);
		   if(value instanceof JButton){
			((JButton) value).doClick();
			JButton boton= (JButton)value;
			this.rowDelete = row;
			deleteRow(rowDelete);
		   }
		   }
	    }
	


	private void deleteRow(int rowDelete2) {
		for (int index = 0; index < listAppointement.size(); index++) {
			if(index==rowDelete2){
				listAppointement.remove(index);
				updateTable();
				DelateAppoint.deleteApp(listAppointement.get(index));
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	 public ArrayList<Appointment> getListAppointement() {
		return listAppointement;
	}

	public void setListAppointement(ArrayList<Appointment> listAppointement) {
		this.listAppointement = listAppointement;
	}



	private class ButtonRenderer extends JButton implements TableCellRenderer {

	    public ButtonRenderer() {
	        setOpaque(true);
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	            boolean hasFocus, int row, int column) {
	        if (value instanceof Component) {
	            return (Component) value;
	        } else {
	            setText((value == null) ? "" : value.toString());
	            return this;
	        }
	    }
	}

}