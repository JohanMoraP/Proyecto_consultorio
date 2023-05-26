package co.edu.uptc.persistence;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

import co.edu.uptc.model.Appointment;
import co.edu.uptc.model.Patient;
import co.edu.uptc.model.Doctor;

public class JsonFileManager {

	private ArrayList<Patient> listPatientsJson;
	private ArrayList<Doctor> listDoctorsJson;
	private ArrayList<Appointment> listAppointmentJson;
	
	public JsonFileManager() {
		// TODO Auto-generated constructor stub
		listPatientsJson= new ArrayList<>();
		listDoctorsJson= new ArrayList<>();
		listAppointmentJson= new ArrayList<>();
		readDataUsers();
		readDataDoctors();
		readDataAppointment();
	}
 
	private void readDataUsers() {
		// TODO Auto-generated method stub
		JSONParser jsonParser = new JSONParser();
		try(FileReader reader= new FileReader("resources/users.json")) {
			Object obj= jsonParser.parse(reader);
			listPatientsJson=listUser((JSONArray) obj);		
			}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		    }catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		   }catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		   }
	}
		private void readDataDoctors() {
			// TODO Auto-generated method stub
			JSONParser jsonParser = new JSONParser();
		try(FileReader reader= new FileReader("resources/doctors.json")) {
			Object obj= jsonParser.parse(reader);
			listDoctorsJson=listDoctor((JSONArray) obj);		
			}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		    }catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		   }catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		   }
	}
		private void readDataAppointment() {
			// TODO Auto-generated method stub
			JSONParser jsonParser = new JSONParser();
		try(FileReader reader= new FileReader("resources/appointment.json")) {
			Object obj= jsonParser.parse(reader);
			listAppointmentJson=listAppointmentJson((JSONArray) obj);		
			}catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		    }catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		   }catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		   }
				
				
				
	}

	private ArrayList<Appointment> listAppointmentJson(JSONArray obj) {
		ArrayList<Appointment> listAppointment= new ArrayList<>();
		JSONArray appointList = (JSONArray) obj;
			for (Object appoint: appointList) {
				try {
					listAppointment.add(generateAppointTemp((JSONObject)appoint));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return listAppointment;
	}

	private Appointment generateAppointTemp(JSONObject obj) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Appointment appointmentTemporal = new Appointment();
		appointmentTemporal.setDoctor(searchDoctor(obj.get("doctor")));
		appointmentTemporal.setPatient(searchPatient(obj.get("paciente")));
		appointmentTemporal.setDateAppoint(formato.parse((String) obj.get("fecha")));
		appointmentTemporal.setHour((String)obj.get("hora"));
		return appointmentTemporal;
	}

	private Patient searchPatient(Object object) {
		for (Patient patient : listPatientsJson) {
			if(patient.getIdentification().equals((String)object)){
				return patient;
			}
		}
		return null;
	}

	private Doctor searchDoctor(Object object) {
		for (Doctor doctor : listDoctorsJson) {
			if(doctor.getIdentification().equals((String)object)){
				return doctor;
			}
		}
		return null;
	}

	private ArrayList<Doctor> listDoctor(JSONArray obj) {
		ArrayList<Doctor> listDoctor= new ArrayList<>();
		JSONArray doctorsList = (JSONArray) obj;
			for (Object doctor: doctorsList) {
				listDoctor.add(generateDoctorTemp((JSONObject)doctor));
			}
		return listDoctor;
	}

	private Doctor generateDoctorTemp(JSONObject obj) {
		Doctor doctorTemporal = new Doctor();
		doctorTemporal.setName((String)obj.get("nombre"));
		doctorTemporal.setLastName((String)obj.get("apellido"));
		doctorTemporal.setAge((Integer.parseInt(""+obj.get("edad"))));
		doctorTemporal.setPhone((String)obj.get("telefono"));
		doctorTemporal.setIdentification((String)obj.get("identificacion"));
		doctorTemporal.setSpeciality((String)obj.get("especialidad"));
		return doctorTemporal;
	}

	private ArrayList<Patient> listUser(JSONArray obj) {
		ArrayList<Patient> listUser= new ArrayList<>();
		JSONArray usersList = (JSONArray) obj;
			for (Object user: usersList) {
				listUser.add(generateUserTemp((JSONObject)user));
			}
		return listUser;
	}

	private Patient generateUserTemp(JSONObject obj) {
		// TODO Auto-generated method stub
		Patient userTemporal = new Patient();
		userTemporal.setName((String)obj.get("nombre"));
		userTemporal.setLastName((String)obj.get("apellido"));
		userTemporal.setAge((Integer.parseInt(""+obj.get("edad"))));
		userTemporal.setPhone((String)obj.get("telefono"));
		userTemporal.setIdentification((String)obj.get("identificacion"));
		return userTemporal;
	}
	
	public void writePatient(ArrayList<Patient> patientsList) {
		try {
			JsonGenerator jsonGenerator = new JsonFactory()	.createGenerator(new FileOutputStream("resources/users.json"));
			jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
			jsonGenerator.writeStartArray();
			for (Patient patient : patientsList) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeStringField("nombre", patient.getName());
				jsonGenerator.writeStringField("apellido", patient.getLastName());
				jsonGenerator.writeNumberField("edad", patient.getAge());
				jsonGenerator.writeStringField("telefono", patient.getPhone());
				jsonGenerator.writeStringField("identificacion", patient.getIdentification());
				jsonGenerator.writeEndObject();
			}
			jsonGenerator.writeEndArray();
			jsonGenerator.flush();
			jsonGenerator.close();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void writeDoctor(ArrayList<Doctor> doctorsList) {
		try {
			JsonGenerator jsonGenerator = new JsonFactory()	.createGenerator(new FileOutputStream("resources/doctors.json"));
			jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
			jsonGenerator.writeStartArray();
			for (Doctor doctor : doctorsList) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeStringField("nombre", doctor.getName());
				jsonGenerator.writeStringField("apellido", doctor.getLastName());
				jsonGenerator.writeNumberField("edad", doctor.getAge());
				jsonGenerator.writeStringField("telefono", doctor.getPhone());
				jsonGenerator.writeStringField("identificacion", doctor.getIdentification());
				jsonGenerator.writeStringField("especialidad", doctor.getSpeciality());
				jsonGenerator.writeEndObject();
			}
			jsonGenerator.writeEndArray();
			jsonGenerator.flush();
			jsonGenerator.close();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	public void writeAppointment(ArrayList<Appointment> appointmentList) {
		try {
			JsonGenerator jsonGenerator = new JsonFactory().createGenerator(new FileOutputStream("resources/appointment.json"));
			jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
			jsonGenerator.writeStartArray();
			for (Appointment appointment : appointmentList) {
				jsonGenerator.writeStartObject();
				jsonGenerator.writeStringField("doctor", appointment.getDoctor().getIdentification());
				jsonGenerator.writeStringField("paciente", appointment.getPatient().getIdentification());
				jsonGenerator.writeStringField("fecha", convertDate(appointment.getDateAppoint()));
				jsonGenerator.writeStringField("hora", appointment.getHour());
				jsonGenerator.writeEndObject();
			}
			jsonGenerator.writeEndArray();
			jsonGenerator.flush();
			jsonGenerator.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	
	private String convertDate(Date dateAppoint) {
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        String date1 = format1.format(dateAppoint);
		return date1;
	}

	public ArrayList<Patient> getListPatientsJson() {
		return listPatientsJson;
	}

	public void setListPatientsJson(ArrayList<Patient> listPatientsJson) {
		this.listPatientsJson = listPatientsJson;
	}

	public ArrayList<Doctor> getListDoctorsJson() {
		return listDoctorsJson;
	}

	public void setListDoctorsJson(ArrayList<Doctor> listDoctorsJson) {
		this.listDoctorsJson = listDoctorsJson;
	}

	public ArrayList<Appointment> getListAppointmentJson() {
		return listAppointmentJson;
	}

	public void setListAppointmentJson(ArrayList<Appointment> listAppointmentJson) {
		this.listAppointmentJson = listAppointmentJson;
	}

}
