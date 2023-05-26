package co.edu.uptc.model;

import java.util.ArrayList;

public class GeneralSchedule {

    public ArrayList<Appointment> scheduleAppoint;

    public void addAppoint(Appointment appoint) {
        this.scheduleAppoint.add(appoint);

    }

    public void cancelAppoint(String idNumber) {
        scheduleAppoint.remove(scheduleAppoint.indexOf(idNumber));
    }

    public ArrayList<Appointment> getScheduleAppoint() {
        return scheduleAppoint;
    }

    public void setScheduleAppoint(ArrayList<Appointment> scheduleAppoint) {
        this.scheduleAppoint = scheduleAppoint;
    }

}
