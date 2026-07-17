package biblioteca.ui;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import biblioteca.dominio.Cd;
import biblioteca.dominio.Libro;
import biblioteca.dominio.Material;
import biblioteca.dominio.Persona;
import biblioteca.dominio.Revista;
import biblioteca.dominio.Usuario;
import biblioteca.repositorio.RepositorioArchivo;
import biblioteca.servicio.Servicio;

public class PanelMateriales extends JPanel implements ActionListener {

    private JTextField campoTitulo;
    private JTextField campoAutor;

    private JButton botonGuardar;
    private JButton botonSalir;
    private JRadioButton jRadioLibro;
    private JRadioButton jRadioCd;
    private JRadioButton jRadioRevista;
    private JPanel panelNorte;
    private JPanel panelCentro;

    private TableMaterialesModel modelo;
    private Servicio<Material> servicio;
    private Material material;
    private int filaEditando = -1;

    public PanelMateriales(TableMaterialesModel modelo, PanelManager manager) {

        setLayout(new BorderLayout(10, 10));
        panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelNorte.setBackground(Color.LIGHT_GRAY);
        panelCentro = new JPanel(new GridLayout(3, 2, 10, 10));

        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        this.modelo = modelo;
        this.servicio = new Servicio<>(new RepositorioArchivo<>("material.dat"));

        cargarRadios();

        panelCentro.add(new JLabel("Titulo"));
        campoTitulo = new JTextField();
        panelCentro.add(campoTitulo);

        panelCentro.add(new JLabel("Autor"));
        campoAutor = new JTextField();
        panelCentro.add(campoAutor);

        botonGuardar = new JButton("Guardar");
        panelCentro.add(botonGuardar);
        botonGuardar.addActionListener(this);

        botonSalir = new JButton("Salir");
        panelCentro.add(botonSalir);
        botonSalir.addActionListener(this);

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);

    }

    private void cargarRadios() {

        
        
        jRadioLibro = new JRadioButton("Libro");
        jRadioCd = new JRadioButton("Cd");
        jRadioRevista = new JRadioButton("Revista");

        // crear el grupo de botones para hacerlo exclusivos
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioLibro);
        buttonGroup.add(jRadioCd);
        buttonGroup.add(jRadioRevista);

        panelNorte.add(jRadioCd);
        panelNorte.add(jRadioLibro);
        panelNorte.add(jRadioRevista);

        



    }

    public void cargarMaterial(Material m, int fila) {

        campoTitulo.setText(m.getTitulo());
        campoAutor.setText(m.getAutor());

        filaEditando = fila;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == botonGuardar) {

            if (campoTitulo.getText().trim().isEmpty()
                    || campoAutor.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Debe completar todos los campos");
                return;

            }

            crearMaterial();

            // Material m = new Libro(campoTitulo.getText().trim(),
            // campoAutor.getText().trim());

            if (filaEditando == -1) {
                 modelo.agregarMaterial(material);
                servicio.agregar(material);
            } else {

                modelo.actualizarMaterial(filaEditando, material);
                servicio.listar().set(filaEditando, material);
                servicio.getRepositorio().guardar(servicio.listar());
                filaEditando = -1;
            }
            JOptionPane.showMessageDialog(null,
                    "Material Guardado correctamente");

            limpiarCampos();

        } else if (e.getSource() == botonSalir) {
            System.exit(0);
        }

    }

    private void crearMaterial() {

        if (jRadioLibro.isSelected()) {

            material = new Libro(campoTitulo.getText().trim(), campoAutor.getText().trim());

        } else if (jRadioCd.isSelected()) {
            material = new Cd(campoTitulo.getText().trim(), campoAutor.getText().trim());

        } else {
            material = new Revista(campoTitulo.getText().trim(), campoAutor.getText().trim());

        }
    }

    private void limpiarCampos() {
        campoTitulo.setText("");
        campoAutor.setText("");

    }

}
