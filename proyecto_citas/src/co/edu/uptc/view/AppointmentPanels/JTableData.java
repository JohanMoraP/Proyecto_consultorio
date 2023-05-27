package co.edu.uptc.view.AppointmentPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.event.ActionEvent;

import co.edu.uptc.model.Appointment;

public class JTableData extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel dtmElements;
	private String[] headers;
	private JTable jtElements;
	private JScrollPane jsTable;
	private ArrayList<Appointment> listAppointement;
	
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
		jtElements.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
		jsTable = new JScrollPane(jtElements, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsTable.addMouseListener(this);
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
		 Object[] column = new Object[6];

		    for (int i = 0; i < listAppointementUser.size(); i++) {
		        column[0] = "" + listAppointementUser.get(i).getIdCita();
		        column[1] = ("" + (listAppointementUser.get(i).getDoctor().getName() + " " + listAppointementUser.get(i).getDoctor().getLastName()));
		        column[2] = "" + (listAppointementUser.get(i).getPatient().getName() + " " + listAppointementUser.get(i).getPatient().getLastName());
		        column[3] = "" + formato.format(listAppointementUser.get(i).getDateAppoint());
		        column[4] = "" + listAppointementUser.get(i).getHour();
		        JButton cancelButton = new JButton("boton cancelar");
	            cancelButton.addActionListener(e -> {
	                JButton button = (JButton) e.getSource();
	                int row = jtElements.rowAtPoint(button.getLocation());
	                listAppointementUser.remove(row);
	                System.out.println(row);
	                // Aquí puedes obtener los datos de la fila correspondiente y realizar las acciones necesarias
	            });
	            column[5] = cancelButton;
                listAppointement = listAppointementUser;
	            dtmElements.addRow(column);
	        }
	    
		
	}
	
	

	public void cleanRowsTable() {
		dtmElements.setRowCount(0);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		 int row = jtElements.rowAtPoint(e.getPoint());
		 System.out.println(row);
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
	            setText((value == null) ? "" : value.toString());
	            return this;
	        }
	    }
}