package biblioteca.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.dominio.Persona;
import biblioteca.dominio.Usuario;
import biblioteca.repositorio.RepositorioArchivo;
import biblioteca.servicio.Servicio;

public class PanelUsuarios extends JPanel implements ActionListener {

    private JTextField campoNombre;
    private JTextField campoApellido;
    private JTextField campoDni;
    private JTextField campoEdad;

    private JButton botonGuardar;
    private JButton botonSalir;
    private TableUsuarioModel modelo;
    private PanelManager manager;
    private Servicio<Persona> servicio;
    private int filaEditando = -1;

    public PanelUsuarios(TableUsuarioModel modelo, PanelManager manager) {
        setLayout(new GridLayout(5, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        this.modelo = modelo;
        this.manager = manager;
        this.servicio = new Servicio<>(new RepositorioArchivo<>("usuario.dat"));

        add(new JLabel("Nombre"));
        campoNombre = new JTextField();
        add(campoNombre);

        add(new JLabel("Apellido"));
        campoApellido = new JTextField();
        add(campoApellido);

        add(new JLabel("Dni"));
        campoDni = new JTextField();
        add(campoDni);

        add(new JLabel("Edad:"));
        campoEdad = new JTextField();
        add(campoEdad);

        botonGuardar = new JButton("Guardar");
        add(botonGuardar);
        botonGuardar.addActionListener(this);

        botonSalir = new JButton("Salir");
        add(botonSalir);
        botonSalir.addActionListener(this);

    }

    public void cargarUsuario(Persona p, int fila) {

        campoApellido.setText(p.getApellido());
        campoNombre.setText(p.getNombre());
        campoDni.setText(String.valueOf(p.getDni()));
        campoEdad.setText(String.valueOf(p.getEdad()));

        filaEditando = fila;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonGuardar) {

            if (campoNombre.getText().trim().isEmpty()
                    || campoApellido.getText().trim().isEmpty() ||
                    campoDni.getText().trim().isEmpty() ||
                    campoEdad.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Debe completar todos los campos");
                return;

            }

            try {

                Persona p = new Usuario(campoNombre.getText().trim(), campoApellido.getText().trim(),
                        Integer.parseInt(campoDni.getText().trim()), Integer.parseInt(campoEdad.getText().trim()));

                if (filaEditando == -1) {
                    modelo.agregarUsuario(p);
                    servicio.agregar(p);
                } else {

                    modelo.actualizarUsuario(filaEditando, p);
                    servicio.listar().set(filaEditando, p);
                    servicio.getRepositorio().guardar(servicio.listar());
                    filaEditando = -1;
                }
                JOptionPane.showMessageDialog(null,
                        "Usuario Guardado correctamente");

                limpiarCampos();
            

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(null,
                        "Dni y Edad deben contener solo numeros");

            }

        } else if (e.getSource() == botonSalir) {
            System.exit(0);
        }

    }

    private void limpiarCampos() {
                campoApellido.setText("");
                campoNombre.setText("");
                campoDni.setText("");
                campoEdad.setText("");
    }

}

// public class PanelUsuarios extends JPanel {
// public PanelUsuarios() {
// setLayout(new GridLayout(4, 2, 10, 10));
// setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

// add(new JLabel("Nombre:"));
// add(new JTextField());

// add(new JLabel("Apellido:"));
// add(new JTextField());

// add(new JLabel("DNI:"));
// add(new JTextField());

// JButton btnGuardar = new JButton("Guardar");
// JButton btnSalir = new JButton("Salir");

// add(btnGuardar);
// add(btnSalir);
// }
// }
