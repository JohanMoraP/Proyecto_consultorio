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

        String source = event.getActionCommand();

        switch (source) {
            case "createDoctor":

                break;

            case "searchDoctor":

                break;
            case "citas":

                break;

            case "usuario":

                break;

            case "doctor":

                break;
            case "asignar":

                break;

            case "Buscar":

                break;
            case "cancelar":

                break;
            case "guardar":

                break;

        }

    }

    public static void main(String[] args) throws IOException {
        new App();
    }
}
