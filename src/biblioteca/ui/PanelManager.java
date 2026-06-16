package biblioteca.ui;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import biblioteca.dominio.Persona;
import biblioteca.dominio.Usuario;
import biblioteca.repositorio.RepositorioArchivo;
import biblioteca.servicio.Servicio;


public class PanelManager extends JPanel {

    private CardLayout cardLayout;
    private PanelUsuarios panelUsuarios;
    private PanelUsuarioTabla panelUsuarioTabla;
    private TableUsuarioModel modelo;
    private Servicio<Persona>  servicio ;

    public PanelManager() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        this.servicio = new Servicio<>(new RepositorioArchivo<>("usuario.dat"));
        

        modelo = new TableUsuarioModel(servicio.listar());

        panelUsuarioTabla = new PanelUsuarioTabla(modelo,this);
        panelUsuarios = new PanelUsuarios(modelo, this);

        add(panelUsuarios, "FORMULARIO");
        add(panelUsuarioTabla, "TABLA");

    }

    public void mostrarFormulario() {
        cardLayout.show(this, "FORMULARIO");

    }

    public void mostrarTabla() {

        cardLayout.show(this, "TABLA");
    }
    public PanelUsuarios getPanelUsuarios (){
        return panelUsuarios;
    }
    public Servicio<Persona> getServicio(){
        return servicio;
    }
}
