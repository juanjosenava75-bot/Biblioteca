package biblioteca.dominio;

public class Bibliotecario extends Persona{

    public Bibliotecario(String nombre, String apellido, int edad, int dni) {
        super(nombre, apellido,edad,dni);
        
    }
        public void registrarMaterial (Material material){
            System.out.println("El bibliotecario " + nombre + " registró ");
            material.mostrarInfo();

        }
    
}
