package biblioteca.ui;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import biblioteca.dominio.EnumPanel;
import biblioteca.dominio.Material;
import biblioteca.dominio.Persona;
import biblioteca.dominio.Usuario;
import biblioteca.repositorio.RepositorioArchivo;
import biblioteca.servicio.Servicio;

public class PanelManager extends JPanel {

    private CardLayout cardLayout;
    private PanelUsuarios panelUsuarios;
    private PanelUsuarioTabla panelUsuarioTabla;
    private PanelPrincipal panelPrincipal;
    private TableUsuarioModel usuariosModel;
    private TableMaterialesModel materialesModel;
    private Servicio<Persona> servicioUsuario;
    private Servicio<Material> servicioMaterial;
    private PanelMateriales panelMateriales;
    private PanelMaterialesTabla panelMaterialesTabla;
    private Prestar prestar;

    public PanelManager() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        this.servicioUsuario = new Servicio<>(new RepositorioArchivo<>("usuario.dat"));
        this.servicioMaterial = new Servicio<>(new RepositorioArchivo<>("material.dat"));

        usuariosModel = new TableUsuarioModel(servicioUsuario.listar());
        materialesModel = new TableMaterialesModel(servicioMaterial.listar());

        panelUsuarioTabla = new PanelUsuarioTabla(usuariosModel, this);
        panelUsuarios = new PanelUsuarios(usuariosModel, this);
        panelPrincipal = new PanelPrincipal(this);
        panelMateriales = new PanelMateriales(materialesModel, this);
        panelMaterialesTabla = new PanelMaterialesTabla(materialesModel, this);
        prestar = new Prestar();

        add(panelPrincipal, EnumPanel.PRINCIPAL.name());
        add(panelUsuarios, EnumPanel.FORMULARIO_USUARIO.name());
        add(panelUsuarioTabla, EnumPanel.TABLA_USUARIO.name());
        add(panelMateriales, EnumPanel.FORMULARIO_MATERIAL.name());
        add(panelMaterialesTabla, EnumPanel.TABLA_MATERIALES.name());
        add(prestar, EnumPanel.PRESTAR.name());
        

      

    }

  

    public void mostrarPanel(EnumPanel panel) {

        cardLayout.show(this, panel.name());

    }

    public PanelUsuarios getPanelUsuarios() {
        return panelUsuarios;
    }

    public PanelMateriales getPanelMateriales() {
        return panelMateriales;
    }

    public Servicio<Persona> getServicio() {
        return servicioUsuario;
    }

    public Servicio<Material> getServicioMaterial() {
        return servicioMaterial;
    }
}
