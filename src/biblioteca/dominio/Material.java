package biblioteca.dominio;

/**
 * REpresenta un material dentro de la biblioteca 
 * puede ser prestado por los usuarios
 */
public abstract class  Material {
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
    

}
