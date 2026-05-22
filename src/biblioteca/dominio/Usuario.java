package biblioteca.dominio;

public class Usuario extends Persona {

    private Material[] materialPrestados;// Relación 1 a N con Libro (un usuario puede tener varios libros prestados).
    private int cantidadMaterial = 0;

    public Usuario(String nombre, String apellido, int maxLibros, int edad ,int dni ) {
        super(nombre, apellido, edad, dni);
        this.materialPrestados = new Material[maxLibros];
    }

    /**
     * Presta material si esta disponible
     * @param material
     * @throws MaterialNoDisponibleException si el material no esta disponible 
     */

    public void prestarMaterial(Material material) throws MaterialNoDisponibleException {

        if (cantidadMaterial < materialPrestados.length) {
            if (material.getEstado() != Estado.DISPONIBLE){
                
                throw new MaterialNoDisponibleException("El material no esta disponible");
            

            } else {
            

            materialPrestados[cantidadMaterial] = material;
            cantidadMaterial++;
            // Cambiamos el estado del material
            material.setEstado(Estado.PRESTADO);
            }

        } else {

            System.out.println(nombre + " no puede prestar más libros.");
        }
    }

    @Override
    public void mostrarMaterial() {
        System.out.println("Libros prestados por " + nombre + ":");
        for (int i = 0; i < cantidadMaterial; i++) {
            materialPrestados[i].mostrarInfo();
        }
        System.out.println("--------------------------------------------");
    }

    public String getNombre() {
        return nombre;
    }

}
