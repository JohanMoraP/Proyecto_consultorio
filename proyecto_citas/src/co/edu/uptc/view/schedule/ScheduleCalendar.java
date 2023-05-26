package co.edu.uptc.view.schedule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import co.edu.uptc.model.Doctor;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ScheduleCalendar extends JPanel {
	private JCalendar calendar;
	private DefaultTableModel model;
	private JTable table;
	private JComboBox<Doctor> doctors;

	public ScheduleCalendar() {
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		calendar = new JCalendar();
		calendar.setDecorationBackgroundColor(new Color(41, 99, 99, 71));
		calendar.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 15));
		calendar.setMinSelectableDate(calendar.getDate());
		add(calendar);
		calendar.addPropertyChangeListener("calendar", new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("calendar")) {

					Calendar cal = (GregorianCalendar) evt.getNewValue();
					System.out.println(cal.getTime());
				}
			}
		});

	}

	public JCalendar getCalendar() {
		return calendar;
	}

	public void setCalendar(JCalendar calendar) {
		this.calendar = calendar;
	}

}
