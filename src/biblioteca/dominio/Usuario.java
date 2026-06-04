package biblioteca.dominio;

import java.util.ArrayList;
import java.util.List;

import biblioteca.excepcion.MaterialNoDisponibleException;

public class Usuario extends Persona  {

    private List <Material> materialPrestados;// Relación 1 a N con Libro (un usuario puede tener varios libros prestados).


    public Usuario(String nombre, String apellido, int edad ,int dni ) {
        super(nombre, apellido, edad, dni);
        this.materialPrestados = new ArrayList<>();
    }



    /**
     * Presta material si esta disponible
     * @param material
     * @throws MaterialNoDisponibleException si el material no esta disponible 
     */

    public void prestarMaterial(Material material) throws MaterialNoDisponibleException {

        
            if (material.getEstado() != Estado.DISPONIBLE){
                
                throw new MaterialNoDisponibleException("El material no esta disponible");
            

            } else {
            
            this.materialPrestados.add(material);
           
            material.setEstado(Estado.PRESTADO);
            }

    
    }

    @Override
    public void mostrarMaterial() {

         System.out.println("--------------------------------------------");

        System.out.println("Usuario  " + nombre + " Dni "+ dni + ":" );
        System.out.println("Materiales prestados por " + nombre );

        for (Material material : materialPrestados) {
            material.mostrarInfo();
        }

        System.out.println("--------------------------------------------");
    }

    public String getNombre() {
        return nombre;
    }

}
