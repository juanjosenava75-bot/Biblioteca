package biblioteca.dominio;

public class Revista extends Material  implements IPrestable{

    private int numero;
    
    public Revista(String titulo, String autor) {
        super(titulo, autor);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Revista : " + titulo + " - Autor: " + autor);
    }

    public void usar (){
        System.out.println("Hojear revista ");
     }

    @Override
    public void prestar() {
         System.out.println("Prestando revista ");
    }

    @Override
    public void devolver() {
         System.out.println("Devolviendo  revista ");
    }
    
}
