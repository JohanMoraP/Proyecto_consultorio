package co.edu.uptc.view.schedule;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import java.awt.*;

public class ScheduleTable extends JPanel {
    private JCalendar calendar;
    private ScheduleTableModel tableModel;
    private DefaultTableModel model;
    private JTable table;

    public ScheduleTable() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        calendar = new JCalendar();
        calendar.setDecorationBackgroundColor(new Color(41, 99, 99, 71));
        calendar.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 15));
        add(calendar);

        tableModel = new ScheduleTableModel();
        model = new DefaultTableModel(tableModel.getScheduleData(), tableModel.getHeaderTable());
        table = new JTable();
        table.setModel(model);
        table.setRowHeight(30); // Altura de las filas
        table.setIntercellSpacing(new Dimension(5, 5)); // Espacio entre celdas
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 15));
        add(scrollPane);
    }

}
