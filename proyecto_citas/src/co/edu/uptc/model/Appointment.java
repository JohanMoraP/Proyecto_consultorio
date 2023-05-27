package co.edu.uptc.model;
import java.util.Date;

public class Appointment {

    private int idCita;
    private Doctor doctor;
    private Patient patient;
    private Date dateAppoint;
    private String hour;

    public Appointment() {
    }

    public Appointment(int idCita,Doctor doctor, Patient patient, Date dateAppoint, String hour) {
        this.idCita=idCita;
        this.doctor = doctor;
        this.patient = patient;
        this.dateAppoint = dateAppoint;
        this.hour = hour;
    }
    

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    @Override
	public String toString() {
		return "Appointment [patient=" + patient + ", dateAppoint=" + dateAppoint + ", hour=" + hour + "]";
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