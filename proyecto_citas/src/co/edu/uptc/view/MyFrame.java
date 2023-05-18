package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import co.edu.uptc.view.DoctorPanels.DoctorPanel;
import co.edu.uptc.view.DoctorPanels.MenuDoctorPanel;
import co.edu.uptc.view.DoctorPanels.SearchDoctorPanel;
import co.edu.uptc.view.UserPanels.MenuUserPanel;
import co.edu.uptc.view.UserPanels.UserPanel;
import co.edu.uptc.view.menuPanels.PanelMenu;
import co.edu.uptc.view.schedule.SchedulePanel;

public class MyFrame extends JFrame {
	private AppointmentPanel appointmentPanel;
	private DoctorPanel doctorPanel;
	private PanelMenu panelMenu;
	private UserPanel userPanel;
	private MenuDoctorPanel menuDoctorPanel;
	private SearchDoctorPanel searchDoctorPanel;
	private MenuUserPanel menuUserPanel;
	private SchedulePanel horario;

	public MyFrame() {

		super("Consultorio");
		Image icon = Toolkit.getDefaultToolkit().getImage("image/icono_Consultorio.png");
		setIconImage(icon);
		this.setSize(1000, 500);
		this.setMinimumSize(new Dimension(400, 400));
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout(30, 30));
		initComponents();
		this.setVisible(true);
		this.revalidate();
		this.pack();
	}

	public void initComponents() {
		/*
		 * appointmentPanel = new AppointmentPanel();
		 * add(appointmentPanel);
		 */

		/*
		 * doctorPanel = new DoctorPanel();
		 * add(doctorPanel);
		 */

		panelMenu = new PanelMenu();
		add(panelMenu, BorderLayout.WEST);

		menuUserPanel = new MenuUserPanel();
		// add(menuUserPanel, BorderLayout.CENTER);

		/*
		 * searchDoctorPanel= new SearchDoctorPanel();
		 * add(searchDoctorPanel,BorderLayout.CENTER);
		 */

		/*
		 * menuDoctorPanel= new MenuDoctorPanel();
		 * add(menuDoctorPanel,BorderLayout.CENTER);
		 */

		/*
		 * userPanel= new UserPanel();
		 * add(userPanel,BorderLayout.CENTER);
		 */
		horario = new SchedulePanel();
		add(horario, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
