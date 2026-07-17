package biblioteca.ui;

import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import biblioteca.dominio.EnumPanel;

public class PanelPrincipal extends JPanel {

    PanelManager manager;

    public PanelPrincipal(PanelManager manager) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.manager = manager;

        JButton botonMostrarUsuarios = crearBoton("Mostrar Lista De Usuarios");
        JButton botonIngresarUsuario = crearBoton("Ingresar Usuarios");
        JButton botonIngresarMaterial = crearBoton("Ingresar Material");
        JButton botonListarMaterial = crearBoton("Listar Materiales");
        JButton botonPrestarMaterial = crearBoton("Prestar");


        
        add(Box.createVerticalGlue());
        add(botonMostrarUsuarios);
        botonMostrarUsuarios.addActionListener(e -> {

            manager.mostrarPanel(EnumPanel.TABLA_USUARIO);

        });

       
        add(Box.createVerticalStrut(10));
        add(botonIngresarUsuario);
        botonIngresarUsuario.addActionListener(e -> {

            manager.mostrarPanel(EnumPanel.FORMULARIO_USUARIO);

        });

       
        add(Box.createVerticalStrut(10));
        add(botonIngresarMaterial);
        botonIngresarMaterial.addActionListener(e -> {

            manager.mostrarPanel(EnumPanel.FORMULARIO_MATERIAL);

        });

        add(Box.createVerticalStrut(10));
        add(botonListarMaterial);
        botonListarMaterial.addActionListener(e -> {

            manager.mostrarPanel(EnumPanel.TABLA_MATERIALES);

        });

         add(Box.createVerticalStrut(10));
        add(botonPrestarMaterial);
        botonPrestarMaterial.addActionListener(e -> {

            manager.mostrarPanel(EnumPanel.PRESTAR);

        });



        add(Box.createVerticalGlue());

    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        return boton;
    }

}
