package biblioteca.dominio;

import java.io.Serializable;

public class Persona implements Comparable<Persona> {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected int dni;

    public Persona(String nombre, String apellido, int edad, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;

    }

    @Override
    public int hashCode() {

        // Genera el hash utilizando el DNI
        // Objetos iguales deben tener el mismo hashCode
        return dni;
    }

    @Override
    public boolean equals(Object obj) {

        // Verifica si es la misma referencia
        if (this == obj)
            return true;

        // Verifica null
        if (obj == null)
            return false;

        // Verifica que ambos objetos sean
        // de la misma clase
        if (getClass() != obj.getClass())
            return false;

        Persona other = (Persona) obj;

        // Igualdad lógica basada en DNI
        if (dni != other.dni)
            return false;

        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void mostrarMaterial() {
        // comportamiento por defecto: no hace nada
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Nombre : " + this.nombre + " Apellido : " + this.apellido;
    }

    @Override
    public int compareTo(Persona o) {
        // TODO Auto-generated method stub
        return this.apellido.compareTo(o.apellido);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

}
