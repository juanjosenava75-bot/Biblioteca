package biblioteca.dominio;

public class Libro extends Material implements IPrestable {

    

    public Libro(String titulo, String autor) {
        super(titulo, autor);
        
    }
    

    @Override
    public void mostrarInfo() {
        System.out.println("Libro: " + titulo + " - Autor: " + autor);
    }

    @Override
    public String toString() {

        return titulo + " " + autor;
    }

    public void usar() {
        System.out.println("Leyendo Libro ");
    }

    @Override
    public void prestar() {
        System.out.println("Prestando Libro ");
    }

    @Override
    public void devolver() {
        System.out.println("Devolviendo  Libro ");
    }

    public void leer() {

        System.out.println("Leyendo libro");
    }


    

}
