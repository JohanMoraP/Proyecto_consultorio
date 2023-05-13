package co.edu.uptc.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private AppointmentPanel appointmentPanel;

	public MyFrame() {

		super("Consultorio");
		this.setExtendedState(MAXIMIZED_BOTH);
		Image icon = Toolkit.getDefaultToolkit().getImage("image/icono_Consultorio.png");
		setIconImage(icon);
		this.setSize(1000, 500);
		this.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
		this.setVisible(true);
		this.revalidate();
		this.pack();
	}

	public void initComponents() {
		appointmentPanel = new AppointmentPanel();
	}
}
