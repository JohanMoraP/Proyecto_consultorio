package co.edu.uptc.model;

import java.time.LocalTime;
import java.util.Date;

public class Appointment {

    private Doctor doctor;
    private Patient patient;
    private Date dateAppoint;
    private LocalTime hour;

    public Appointment() {
    }

    public Date getDateAppoint() {
		return dateAppoint;
	}

	public void setDateAppoint(Date dateAppoint) {
		this.dateAppoint = dateAppoint;
	}

	public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

}