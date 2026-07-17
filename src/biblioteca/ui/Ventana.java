package biblioteca.ui;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import biblioteca.dominio.EnumPanel;

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

        JMenuItem itemPrincipal = new JMenuItem("Principal");
        itemPrincipal.addActionListener(e-> panelManager.mostrarPanel(EnumPanel.PRINCIPAL));

        JMenuItem itemCrear = new JMenuItem("Crear Usuario");
        itemCrear.addActionListener(e-> panelManager.mostrarPanel(EnumPanel.FORMULARIO_USUARIO));

        JMenuItem itemConsulta = new JMenuItem("Consulta Usuarios");
        itemConsulta.addActionListener(e-> panelManager.mostrarPanel(EnumPanel.TABLA_USUARIO));

          JMenuItem itemCrearMaterial = new JMenuItem("Ingreasar Material");
        itemCrearMaterial.addActionListener(e-> panelManager.mostrarPanel(EnumPanel.FORMULARIO_MATERIAL));

        JMenuItem itemTablaMaterial = new JMenuItem("Listar Materiales");
        itemTablaMaterial.addActionListener(e-> panelManager.mostrarPanel(EnumPanel.TABLA_MATERIALES));


        menu.add(itemCrear);
        menu.add(itemConsulta);
        menu.add(itemPrincipal);
        menu.add(itemCrearMaterial);
        menu.add(itemTablaMaterial);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        
        this.setVisible(true);


    }




    public static void main(String[] args) {
        new Ventana();
    }
}
