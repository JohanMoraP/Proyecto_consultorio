package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	public MyFrame() {

		super("Consultorio");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setSize(1000, 500);
		this.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(new Color(247, 249, 252));
		initComponents();
		this.setVisible(true);
		this.revalidate();
		this.pack();

	}

	public void initComponents() {

	}
}
