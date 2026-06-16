package biblioteca.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import biblioteca.dominio.Persona;

public class PanelUsuarioTabla extends JPanel {

    public PanelUsuarioTabla(TableUsuarioModel modelo, PanelManager manager) {

        setLayout(new BorderLayout());

        JTable tabla = new JTable(modelo);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton botonEditar = new JButton("Editar");
        JButton botonEliminar = new JButton("Eliminar");

        panelBotones.add(botonEditar);
        panelBotones.add(botonEliminar);

        botonEliminar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                manager.getServicio().listar().remove(fila);
                manager.getServicio().getRepositorio().guardar(manager.getServicio().listar());
                modelo.fireTableDataChanged();

                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
            }
        });

        botonEditar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                Persona p = modelo.getPersonas().get(fila);
                manager.mostrarFormulario();
                manager.getPanelUsuarios().cargarUsuario(p, fila);

            }

        });

        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    // public static void main(String[] args) {
    // JFrame frame = new JFrame("Lista de Personas");

    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setSize(400,200);

    // frame.getContentPane().add(new PanelUsuarioTabla());
    // frame.setVisible(true);

    // }
}
