package biblioteca.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import biblioteca.dominio.EnumPanel;
import biblioteca.dominio.Material;


public class PanelMaterialesTabla extends JPanel {


     public PanelMaterialesTabla(TableMaterialesModel modelo, PanelManager manager) {

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
                manager.getServicioMaterial().listar().remove(fila);
                manager.getServicioMaterial().getRepositorio().guardar(manager.getServicioMaterial().listar());
                modelo.fireTableDataChanged();

                JOptionPane.showMessageDialog(null, "Material eliminado correctamente.");
            }
        });

        botonEditar.addActionListener(e -> {
            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                Material m = modelo.getMaterials().get(fila);
                manager.mostrarPanel(EnumPanel.FORMULARIO_MATERIAL);
                manager.getPanelMateriales().cargarMaterial(m, fila);

            }

        });

        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
