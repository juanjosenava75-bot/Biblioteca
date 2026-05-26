package biblioteca.dominio;

public class Cd  extends Material {

    public Cd(String titulo, String autor) {
        super(titulo, autor);
    }

    public Cd() {
    }

    @Override
    public void usar() {
       System.out.println("Cd tocando");
    }

    @Override
    public void prestar() {
         System.out.println("Prestando Cd ");
    }

    @Override
    public void devolver() {
        System.out.println("Devolviendo  Cd ");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Cd : " + titulo + " - Autor: " + autor);
    }

   
 
}
