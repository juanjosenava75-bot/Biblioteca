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

    
    
}
