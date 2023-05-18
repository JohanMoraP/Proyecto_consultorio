package co.edu.uptc.view.schedule;

import javax.swing.table.DefaultTableModel;

public class ScheduleTableModel extends DefaultTableModel {

    // Datos del horario semanal
    private String[] headerTable;
    // private String[] timeSlots;
    private Object[][] scheduleData;

    public ScheduleTableModel() {
        initComponents();
    }

    private void initComponents() {
        headerTable = new String[] { "	", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", " " };
        // timeSlots = new String [] {"8:00 - 9:00", "9:00 - 10:00", "10:00 - 11:00",
        // "11:00 - 12:00", "12:00 - 13:00"};

        scheduleData = new Object[][] {
                { "8:00-9:00", "21", "31", "41", "51" },
                { "9:00-10:00", "22", "32", "42", "52" },
                { "10:00-11:00", "23", "33", "43", "53" },
                { "11:00-12:00", "24", "34", "44", "54" },
                { "12:00-01:00", "25", "35", "45", "55" },
                { "01:00-02:00", "26", "36", "46", "56" },
                { "02:00-03:00", "27", "37", "47", "57" },
                { "03:00-04:00", "28", "38", "48", "58" },
                { "04:00-05:00", "29", "39", "49", "59" }
        };
    }

    public Object[][] getScheduleData() {
        return scheduleData;
    }

    public void setScheduleData(Object[][] scheduleData) {
        this.scheduleData = scheduleData;
    }

    public String[] getHeaderTable() {
        return headerTable;
    }

    public void setHeaderTable(String[] headerTable) {
        this.headerTable = headerTable;
    }

}
