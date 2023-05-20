package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.uptc.view.Home;
import co.edu.uptc.view.MyFrame;
import co.edu.uptc.view.PanelBase;
import co.edu.uptc.view.AppointmentPanels.AppointmentPanel;
import co.edu.uptc.view.DoctorPanels.DoctorPanel;
import co.edu.uptc.view.schedule.SchedulePanel;

public class App implements ActionListener {
    private MyFrame frame;

    public App() {
        frame = new MyFrame(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String source = event.getActionCommand();

        switch (source) {
            case "createDoctor":
                frame.getBase().removeAll();
                DoctorPanel doctor = new DoctorPanel();
                frame.getBase().add(doctor);
                break;

            case "searchDoctor":

                break;
            case "citas":
                frame.getBase().removeAll();
                SchedulePanel schedule = new SchedulePanel(this);
                frame.getBase().add(schedule);
                frame.revalidate();
                frame.repaint();
                break;

            case "usuario":

                break;

            case "doctor":

                break;
            case "asignar":
                frame.getBase().removeAll();
                AppointmentPanel appointment = new AppointmentPanel();
                frame.getBase().add(appointment);
                frame.revalidate();
                frame.repaint();
                break;

            case "Buscar":

                break;
            case "cancelar":

                break;
            case "guardar":

                break;

            case "home":
                frame.getBase().removeAll();
                Home home = new Home();
                frame.getBase().add(home);
                frame.revalidate();
                frame.repaint();
                break;

        }
    }

    public static void main(String[] args) throws IOException {
        new App();
    }
}
