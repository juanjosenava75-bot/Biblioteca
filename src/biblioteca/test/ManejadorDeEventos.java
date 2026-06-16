package biblioteca.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManejadorDeEventos implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      System.out.println("Evento Disparado " + e.getActionCommand());
    }

}
