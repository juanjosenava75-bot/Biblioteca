package biblioteca.ui;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame{

    private PanelManager panelManager;

    public Ventana() {
        super("Sistema Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,600);

        panelManager = new PanelManager();
        getContentPane().add(panelManager,BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu ("Opciones");

        JMenuItem itemCrear = new JMenuItem("Crear Usuario");
        itemCrear.addActionListener(e-> panelManager.mostrarFormulario());

        JMenuItem itemConsulta = new JMenuItem("Consulta Usuarios");
        itemConsulta.addActionListener(e-> panelManager.mostrarTabla());



        menu.add(itemCrear);
        menu.add(itemConsulta);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        
        this.setVisible(true);


    }




    public static void main(String[] args) {
        new Ventana();
    }
}
