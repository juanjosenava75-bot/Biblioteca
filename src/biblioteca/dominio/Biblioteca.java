package biblioteca.dominio;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    // Relación N a N con Usuario y Libro (muchos usuarios pueden tomar muchos
    // libros).

    private List<Persona> personas;
    private List<Material> material;

    public Biblioteca() {
        this.personas = new ArrayList<>();
        this.material = new ArrayList<>();
    }

    public void agregarPersona(Persona p) {

        personas.add(p);

    }

    public void agregarMaterial(Material l) {

        material.add(l);

    }

    public void mostrarEstado() {
        System.out.println("Estado de la biblioteca:");

        for (Persona p : personas) {
            p.mostrarMaterial();
        }

        System.out.println("--------------------------------------------");

        for (Material m : material) {
            System.out.println(
                    m.titulo + " - " + m.getEstado());
        }

    }

    public Usuario buscarUsuario(int dni) {

        return (Usuario) personas.stream()
                .filter(u -> u.getDni() == dni)
                .findFirst()
                .orElse(null);
    }

    public Material buscarMaterial(String titulo) {

        return material.stream()
                .filter(m -> m.getTitulo()
                        .equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }

    

}
