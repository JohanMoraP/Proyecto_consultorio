package co.edu.uptc.presenter;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

import co.edu.uptc.model.Appointment;
import co.edu.uptc.model.ControlModel;
import co.edu.uptc.model.Doctor;
import co.edu.uptc.model.Patient;
import co.edu.uptc.persistence.JsonFileManager;
import co.edu.uptc.view.GreenButton;
import co.edu.uptc.view.Home;
import co.edu.uptc.view.MyFrame;
import co.edu.uptc.view.SearchBarId;
import co.edu.uptc.view.AppointmentPanels.AppointmentPanel;
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
	private  AppointmentPanel appointment;
	
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

	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		switch (source) {
		case "citas":
			frame.getBase().removeAll();
			MenuAppointment appointMenu = new MenuAppointment(this);
			frame.getBase().add(appointMenu);
			frame.revalidate();
			frame.repaint();
			break;
		case "newAppoint":
			frame.getBase().removeAll();
			schedule = new SchedulePanel(this, controlModel.specialityList);
			frame.getBase().add(schedule);
			frame.revalidate();
			frame.repaint();
			break;
		case "delateAppoint" :
			frame.getBase().removeAll();
			DelateAppoint delate = new DelateAppoint(this);
			frame.getBase().add(delate);
			frame.revalidate();
			frame.repaint();
			break;
		case "buscarIdDelateAppoint":
				DelateAppoint delate1 = new DelateAppoint(this);
			
			if(controlModel.searchUser(searchUserAppoin.idSearch())!=null){
				searchUserAppoin.addData(controlModel.searchUser(searchUserAppoin.idSearch()));
				dataAppointment[0]=(controlModel.searchUserObject(searchUserAppoin.idSearch()));
				frame.revalidate();
				frame.repaint();
			}
			else {
				JOptionPane.showMessageDialog(frame, "PACIENTE NO ENCONTRADO");
				frame.getBase().removeAll();
				searchUserAppoin = new SearchUser(this);
				frame.getBase().add(searchUserAppoin);
				frame.revalidate();
				frame.repaint();
			}  
			break;
		case "doctors":
			schedule.cleanComboDoctors();
			schedule.addDoctorsDisponibility(controlModel.doctorsSpecialitySearch(schedule.getSpecialitySearch()), this);
			frame.revalidate();
			frame.repaint();
			break;

		case "hours":
			schedule.cleanComboHours();
			schedule.addHoursDisponibility(controlModel.listHourDisponibility(schedule.getSendDoctorSelected(), schedule.getDateAppointment()));
			dataAppointment[1]=(controlModel.searchDoctorObject(schedule.getSendDoctorSelected()));
			dataAppointment[3]=schedule.getDateAppointment();
			frame.revalidate();
			frame.repaint();
			break;

		case "usuario":
			frame.getBase().removeAll();
			menuUserPanel = new MenuUserPanel(this);
			frame.getBase().add(menuUserPanel);
			frame.revalidate();
			frame.repaint();
			break;

		case "doctor":
			frame.getBase().removeAll();
			menuDoctorPanel = new MenuDoctorPanel(this);
			frame.getBase().add(menuDoctorPanel);
			frame.revalidate();
			frame.repaint();
			break;

		case "asignar":
			dataAppointment[2]=schedule.getSendHourSelected();
			frame.getBase().removeAll();
			searchUserAppoin = new SearchUser(this);
			frame.getBase().add(searchUserAppoin);
			frame.revalidate();
			frame.repaint();
			break;

		case "createDoctor":
			frame.getBase().removeAll();
			doctor = new DoctorPanel(this ,controlModel.specialityList);
			frame.getBase().add(doctor);
			frame.revalidate();
			frame.repaint();
			break;

		case "searchDoctor":
			frame.getBase().removeAll();
			searchDoctorPanel = new SearchDoctorPanel(this);
			frame.getBase().add(searchDoctorPanel);
			frame.revalidate();
			frame.repaint();
			break;

		case "createUser":
			frame.getBase().removeAll();
			user = new UserPanel(this);
			frame.getBase().add(user);
			frame.revalidate();
			frame.repaint();
			break;

		case "searchUser":
			frame.getBase().removeAll();
			searchUser = new SearchUserPanel(this);
			frame.getBase().add(searchUser);
			frame.revalidate();
			frame.repaint();
			break;

		case "buscarIdUser":
			if (controlModel.searchUser(searchUser.idSearch()) != null) {
				searchUser.addData(controlModel.searchUser(searchUser.idSearch()));
				frame.revalidate();
				frame.repaint();
			} else {
				JOptionPane.showMessageDialog(frame, "PACIENTE NO ENCONTRADO");
				frame.getBase().removeAll();
				searchUser = new SearchUserPanel(this);
				frame.getBase().add(searchUser);
				frame.revalidate();
				frame.repaint();
			}
			break;

		case "buscarIdBuscar":
			if(controlModel.searchUser(searchUserAppoin.idSearch())!=null){
				searchUserAppoin.addData(controlModel.searchUser(searchUserAppoin.idSearch()));
				dataAppointment[0]=(controlModel.searchUserObject(searchUserAppoin.idSearch()));
				frame.revalidate();
				frame.repaint();
			}
			else {
				JOptionPane.showMessageDialog(frame, "PACIENTE NO ENCONTRADO");
				frame.getBase().removeAll();
				searchUserAppoin = new SearchUser(this);
				frame.getBase().add(searchUserAppoin);
				frame.revalidate();
				frame.repaint();
			}                   
			break;

		case "buscarIdDoctor":
			if (controlModel.searchDoctor(searchDoctorPanel.idSearch()) != null) {
				searchDoctorPanel.addData(controlModel.searchDoctor(searchDoctorPanel.idSearch()), controlModel.specialityList);
				frame.revalidate();
				frame.repaint();
			} else {
				JOptionPane.showMessageDialog(frame, "MEDICO NO ENCONTRADO");
				frame.getBase().removeAll();
				searchDoctorPanel = new SearchDoctorPanel(this);
				frame.getBase().add(searchDoctorPanel);
				frame.revalidate();
				frame.repaint();
			}
			break;

		case "cancelarUser":
			frame.getBase().removeAll();
			menuUserPanel = new MenuUserPanel(this);
			frame.getBase().add(menuUserPanel);
			frame.revalidate();
			frame.repaint();
			break;

		case "guardarUser":
			String[] data = user.sendDataFormUser();
			controlModel.listPatients.add(new Patient(data[0], data[1],
					Integer.parseInt(data[2]), data[3], data[4]));
			jsonFileManager.writePatient(controlModel.listPatients);
			JOptionPane.showMessageDialog(frame, "PACIENTE GUARDADO CON EXITO");
			user.cleanForm();
			break;

		case "cancelarDoctor":
			frame.getBase().removeAll();
			menuDoctorPanel = new MenuDoctorPanel(this);
			frame.getBase().add(menuDoctorPanel);
			frame.revalidate();
			frame.repaint();
			break;

		case "guardarDoctor":
			String[] data2 = doctor.sendDataFormDoctor();
			controlModel.listDoctors.add(new Doctor(data2[0], data2[1],
					Integer.parseInt(data2[2]), data2[3], data2[4], data2[5]));
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
			controlModel.generalSchedule.scheduleAppoint.add(new Appointment((Doctor)dataAppointment[1],(Patient)dataAppointment[0], fecha, ""+dataAppointment[2]));
			jsonFileManager.writeAppointment(controlModel.generalSchedule.getScheduleAppoint());
			JOptionPane.showMessageDialog(frame, "CITA GUARDADA CON EXITO");
			frame.getBase().removeAll();
			schedule = new SchedulePanel(this, controlModel.specialityList);
			frame.getBase().add(schedule);
			frame.revalidate();
			frame.repaint();
			break;

		case "home":
			frame.getBase().removeAll();
			home = new Home();
			frame.getBase().add(home);
			frame.revalidate();
			frame.repaint();
			break;
		}
	}

}
