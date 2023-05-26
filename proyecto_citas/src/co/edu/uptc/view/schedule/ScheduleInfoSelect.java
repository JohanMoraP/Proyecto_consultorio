package co.edu.uptc.view.schedule;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import co.edu.uptc.model.Doctor;

public class ScheduleInfoSelect extends JPanel {
	private JLabel doctorLabel;
	private JLabel horaLabel;
	private JComboBox comboDoctors;
	private JComboBox horas;

	public ScheduleInfoSelect(ArrayList<Doctor> doctors) {
		// TODO Auto-generated constructor stub
		initComponents(doctors);
	}

	private void initComponents(ArrayList<Doctor> doctors) {

		doctorLabel = new JLabel("Doctores");
		add(doctorLabel);
		comboDoctors = new JComboBox();

		Iterator<Doctor> iterator = doctors.iterator();
		comboDoctors.removeAllItems();

		while (iterator.hasNext()) {
			Doctor doctor = iterator.next();
			comboDoctors.addItem(doctor.getName() + " " + doctor.getLastName());
		}

		add(comboDoctors);
		horaLabel = new JLabel("Hora");
		add(doctorLabel);
		horas = new JComboBox<String>();
		add(horas);
	}

}
