package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import co.edu.uptc.model.Appointment;
import co.edu.uptc.model.ControlModel;
import co.edu.uptc.model.Doctor;
import co.edu.uptc.model.Patient;
import co.edu.uptc.persistence.JsonFileManager;
import co.edu.uptc.view.Home;
import co.edu.uptc.view.MyFrame;
import co.edu.uptc.view.AppointmentPanels.DelateAppoint;
import co.edu.uptc.view.AppointmentPanels.MenuAppointment;
import co.edu.uptc.view.DoctorPanels.DoctorPanel;
import co.edu.uptc.view.DoctorPanels.MenuDoctorPanel;
import co.edu.uptc.view.DoctorPanels.SearchDoctorPanel;
import co.edu.uptc.view.UserPanels.MenuUserPanel;
import co.edu.uptc.view.UserPanels.SearchUserPanel;
import co.edu.uptc.view.UserPanels.UserPanel;
import co.edu.uptc.view.schedule.SchedulePanel;
import co.edu.uptc.view.schedule.SearchUser;

public class App implements ActionListener{
	private MyFrame frame;
	private JsonFileManager jsonFileManager;
	private  DoctorPanel doctor;
	private  MenuDoctorPanel menuDoctorPanel;
	private  MenuUserPanel menuUserPanel;
	private  Home home;
	private  ControlModel controlModel;
	private  SchedulePanel schedule;
	private DelateAppoint delate; 
	
	private  SearchDoctorPanel searchDoctorPanel;
	private  UserPanel user;
	private  SearchUserPanel searchUser;
	private   SearchUser searchUserAppoin;
	private   Object[]  dataAppointment;

	public App() {
		controlModel = new ControlModel();
		doctor = new DoctorPanel(this, controlModel.specialityList);
		user = new UserPanel(this);
		jsonFileManager = new JsonFileManager();
		schedule = new SchedulePanel(this,controlModel.specialityList);
		dataAppointment= new Object[4];
		frame = new MyFrame(this);

		controlModel.listPatients=jsonFileManager.getListPatientsJson();
		controlModel.listDoctors=jsonFileManager.getListDoctorsJson();
		controlModel.generalSchedule.scheduleAppoint=jsonFileManager.getListAppointmentJson();
		
	}
	
	public void cleanFrame() {
        frame.getBase().removeAll();

    }
    public void revalidateFrame() {
    	frame.revalidate();
        frame.repaint();
    }

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		switch (source) {
		case "citas":
			cleanFrame();
			MenuAppointment appointMenu = new MenuAppointment(this);
			frame.getBase().add(appointMenu);
			revalidateFrame();
			break;
		case "newAppoint":
			cleanFrame();
			schedule = new SchedulePanel(this, controlModel.specialityList);
			frame.getBase().add(schedule);
			revalidateFrame();
			break;
		case "delateAppoint" :
			cleanFrame();
			delate = new DelateAppoint(this);
			frame.getBase().add(delate);
			revalidateFrame();
			break;
		case "buscarIdDelateAppoint":
			if(controlModel.searchUser(delate.idSearch())!=null){
				delate.addDataTable(controlModel.searchAppointForUser(delate.idSearch()));
				revalidateFrame();
				jsonFileManager.setListAppointmentJson(	delate.appointmentList());
			}
			else {
				JOptionPane.showMessageDialog(frame, "PACIENTE NO ENCONTRADO");
				cleanFrame();
				searchUserAppoin = new SearchUser(this);
				frame.getBase().add(searchUserAppoin);
				revalidateFrame();
			}  
			
			break;
		case "doctors":
			schedule.cleanComboDoctors();
			schedule.addDoctorsDisponibility(controlModel.doctorsSpecialitySearch(schedule.getSpecialitySearch()), this);
			revalidateFrame();
			break;

		case "hours":
			schedule.cleanComboHours();
			schedule.addHoursDisponibility(controlModel.listHourDisponibility(schedule.getSendDoctorSelected(), schedule.getDateAppointment()));
			dataAppointment[1]=(controlModel.searchDoctorObject(schedule.getSendDoctorSelected()));
			dataAppointment[3]=schedule.getDateAppointment();
			revalidateFrame();
			break;

		case "usuario":
			cleanFrame();
			menuUserPanel = new MenuUserPanel(this);
			frame.getBase().add(menuUserPanel);
			revalidateFrame();
			break;

		case "doctor":
			cleanFrame();
			menuDoctorPanel = new MenuDoctorPanel(this);
			frame.getBase().add(menuDoctorPanel);
			revalidateFrame();
			break;

		case "asignar":
			dataAppointment[2]=schedule.getSendHourSelected();
			frame.getBase().removeAll();
			searchUserAppoin = new SearchUser(this);
			frame.getBase().add(searchUserAppoin);
			revalidateFrame();
			break;

		case "createDoctor":
			cleanFrame();
			doctor = new DoctorPanel(this ,controlModel.specialityList);
			frame.getBase().add(doctor);
			revalidateFrame();
			break;

		case "searchDoctor":
			cleanFrame();
			searchDoctorPanel = new SearchDoctorPanel(this);
			frame.getBase().add(searchDoctorPanel);
			revalidateFrame();
			break;

		case "createUser":
			cleanFrame();
			user = new UserPanel(this);
			frame.getBase().add(user);
			revalidateFrame();
			break;

		case "searchUser":
			cleanFrame();
			searchUser = new SearchUserPanel(this);
			frame.getBase().add(searchUser);
			revalidateFrame();
			break;

		case "buscarIdUser":
			if (controlModel.searchUser(searchUser.idSearch()) != null) {
				searchUser.addData(controlModel.searchUser(searchUser.idSearch()));
				revalidateFrame();
			} else {
				JOptionPane.showMessageDialog(frame, "PACIENTE NO ENCONTRADO");
				cleanFrame();
				searchUser = new SearchUserPanel(this);
				frame.getBase().add(searchUser);
				revalidateFrame();
			}
			break;

		case "buscarIdBuscar":
			if(controlModel.searchUser(searchUserAppoin.idSearch())!=null){
				searchUserAppoin.addData(controlModel.searchUser(searchUserAppoin.idSearch()));
				dataAppointment[0]=(controlModel.searchUserObject(searchUserAppoin.idSearch()));
				revalidateFrame();
			}
			else {
				JOptionPane.showMessageDialog(frame, "PACIENTE NO ENCONTRADO");
				cleanFrame();
				searchUserAppoin = new SearchUser(this);
				frame.getBase().add(searchUserAppoin);
				revalidateFrame();
			}                   
			break;

		case "buscarIdDoctor":
			if (controlModel.searchDoctor(searchDoctorPanel.idSearch()) != null) {
				searchDoctorPanel.addData(controlModel.searchDoctor(searchDoctorPanel.idSearch()), controlModel.specialityList);
				revalidateFrame();
			} else {
				JOptionPane.showMessageDialog(frame, "MEDICO NO ENCONTRADO");
				frame.getBase().removeAll();
				searchDoctorPanel = new SearchDoctorPanel(this);
				frame.getBase().add(searchDoctorPanel);
				revalidateFrame();
			}
			break;

		case "cancelarUser":
			cleanFrame();
			menuUserPanel = new MenuUserPanel(this);
			frame.getBase().add(menuUserPanel);
			revalidateFrame();
			break;

		case "guardarUser":
			String[] data = user.sendDataFormUser();
			controlModel.listPatients.add(new Patient(data[0], data[1],	Integer.parseInt(data[2]), data[3], data[4]));
			jsonFileManager.writePatient(controlModel.listPatients);
			JOptionPane.showMessageDialog(frame, "PACIENTE GUARDADO CON EXITO");
			user.cleanForm();
			break;

		case "cancelarDoctor":
			cleanFrame();
			menuDoctorPanel = new MenuDoctorPanel(this);
			frame.getBase().add(menuDoctorPanel);
			revalidateFrame();
			break;

		case "guardarDoctor":
			String[] data2 = doctor.sendDataFormDoctor();
			controlModel.listDoctors.add(new Doctor(data2[0], data2[1],	Integer.parseInt(data2[2]), data2[3], data2[4], data2[5]));
			jsonFileManager.writeDoctor(controlModel.listDoctors);
			JOptionPane.showMessageDialog(frame, "DOCTOR GUARDADO CON EXITO");
			doctor.cleanForm();
			break;

		case "cancelarCita":
			System.out.println("CANCELAR CITA");
			break;

		case "guardarCita":
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
			Date fecha= new Date();
			try {
				fecha = formato.parse(""+dataAppointment[3]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			controlModel.generalSchedule.scheduleAppoint.add(new Appointment(controlModel.generalSchedule.scheduleAppoint.size(),(Doctor)dataAppointment[1],(Patient)dataAppointment[0], fecha, ""+dataAppointment[2]));
			jsonFileManager.writeAppointment(controlModel.generalSchedule.getScheduleAppoint());
			JOptionPane.showMessageDialog(frame, "CITA GUARDADA CON EXITO");
			cleanFrame();
			schedule = new SchedulePanel(this, controlModel.specialityList);
			frame.getBase().add(schedule);
			revalidateFrame();
			break;

		case "home":
			cleanFrame();
			home = new Home();
			frame.getBase().add(home);
			revalidateFrame();
			break;
		}
	}

	public static void appointementDelete(Appointment appointment) {
	}

}
