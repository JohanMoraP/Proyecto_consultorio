package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import co.edu.uptc.model.ControlModel;
import co.edu.uptc.model.Doctor;
import co.edu.uptc.model.Patient;
import co.edu.uptc.persistence.JsonFileManager;
import co.edu.uptc.view.Home;
import co.edu.uptc.view.MyFrame;
import co.edu.uptc.view.AppointmentPanels.AppointmentPanel;
import co.edu.uptc.view.DoctorPanels.DoctorPanel;
import co.edu.uptc.view.DoctorPanels.MenuDoctorPanel;
import co.edu.uptc.view.DoctorPanels.SearchDoctorPanel;
import co.edu.uptc.view.UserPanels.MenuUserPanel;
import co.edu.uptc.view.UserPanels.SearchUserPanel;
import co.edu.uptc.view.UserPanels.UserPanel;
import co.edu.uptc.view.schedule.SchedulePanel;

public class App implements ActionListener {
    private MyFrame frame;
    private JsonFileManager jsonFileManager = new JsonFileManager();
    private MenuDoctorPanel menuDoctorPanel;
    private MenuUserPanel menuUserPanel;
    private SchedulePanel schedule;
    private AppointmentPanel appointment;
    private DoctorPanel doctor = new DoctorPanel(this);
    private SearchDoctorPanel searchDoctorPanel;
    private UserPanel user = new UserPanel(this);
    private SearchUserPanel searchUser;
    private Home home;
    private ControlModel controlModel = new ControlModel();

    public App() {
        frame = new MyFrame(this);
        controlModel.listPatients = jsonFileManager.getListPatientsJson();
        controlModel.listDoctors = jsonFileManager.getListDoctorsJson();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String source = event.getActionCommand();
        switch (source) {

            case "citas":
                frame.getBase().removeAll();
                schedule = new SchedulePanel(this, controlModel.getListDoctors());
                frame.getBase().add(schedule);
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
                frame.getBase().removeAll();
                appointment = new AppointmentPanel(this);
                frame.getBase().add(appointment);
                frame.revalidate();
                frame.repaint();
                break;

            case "createDoctor":
                frame.getBase().removeAll();
                doctor = new DoctorPanel(this);
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

            case "buscarIdDoctor":
                if (controlModel.searchDoctor(searchDoctorPanel.idSearch()) != null) {
                    searchDoctorPanel.addData(controlModel.searchDoctor(searchDoctorPanel.idSearch()));
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
                JOptionPane.showMessageDialog(frame, "GUARDAR CITA");
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

    public static void main(String[] args) {
        new App();
    }
}
