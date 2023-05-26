package co.edu.uptc.model;

import java.time.LocalTime;
import java.util.Date;

public class Appointment {

    private Doctor doctor;
    private Patient patient;
    private Date dateAppoint;
    private String hour;

    public Appointment() {
    }

    public Appointment(Doctor doctor, Patient patient, Date dateAppoint, String hour) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateAppoint = dateAppoint;
        this.hour = hour;
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

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

}