package biblioteca.dominio;

import java.io.Serializable;

/**
 * REpresenta un material dentro de la biblioteca 
 * puede ser prestado por los usuarios
 */
public abstract class  Material implements IPrestable {
    protected String titulo;
    protected String autor;
    private Estado estado;

    public Material(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.estado = Estado.DISPONIBLE; 
    }

    public Material (){
        
    }
    public  abstract void usar();
    

    public void mostrarInfo (){
        System.out.println("Material: " + titulo + " - Autor: " + autor);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "Material: " + titulo + " - Autor: " + autor;
    }
    

}
