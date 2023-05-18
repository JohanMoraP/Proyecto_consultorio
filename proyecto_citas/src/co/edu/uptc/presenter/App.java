package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import co.edu.uptc.view.MyFrame;

public class App implements ActionListener {
    private MyFrame frame;

    public App() {
        frame = new MyFrame(this);
    }

    @Override
	public void actionPerformed(ActionEvent event) {
		
		try {
			String source = event.getActionCommand();

			switch (source) {
			case "citas": 
				
				break;
				
			case "usuario": 

				break;

			case"doctor":
				
				break;
			case "asignar":

				break;

			case "ingles":

				break;

			}}
		
		catch (IOException e) {
			e.printStackTrace();
		}

    public static void main(String[] args) throws IOException {
        new App();
    }
}