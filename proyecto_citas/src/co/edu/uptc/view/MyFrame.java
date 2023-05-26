package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import co.edu.uptc.view.menuPanels.PanelMenu;

public class MyFrame extends JFrame {

	private PanelMenu menu;
	private PanelBase base;

	public MyFrame(ActionListener listener) {
		super("Consultorio");
		Image icon = Toolkit.getDefaultToolkit().getImage("images/icono_Consultorio.png");
		setIconImage(icon);
		this.setSize(1000, 500);
		this.setMinimumSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents(listener);
		this.revalidate();
		this.pack();
		this.setVisible(true);
		this.setExtendedState(MAXIMIZED_BOTH);

	}

	public void initComponents(ActionListener listener) {
		setLayout(new BorderLayout());
		menu = new PanelMenu(listener);
		add(menu, BorderLayout.WEST);

		base = new PanelBase();
		int espacio = 15;
		base.setBorder(BorderFactory.createEmptyBorder(espacio, espacio, espacio, espacio));
		add(base, BorderLayout.CENTER);

	}
	
	
	
	
	
	public PanelBase getBase() {
		return base;
	}

	public void setBase(PanelBase base) {
		this.base = base;
	}

}
