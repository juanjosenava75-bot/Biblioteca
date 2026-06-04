package biblioteca.repositorio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//Genéricos
// <T> indica que la clase es GENERICA
// T representa un tipo de dato que se define cuando se crea el objeto.
// Por ejemplo:
//
// RepositorioArchivo<Usuario>
// RepositorioArchivo<Material>
//
// De esta manera la misma clase puede trabajar
// con distintos tipos de objetos.
//


public class RepositorioArchivo<T> implements IRepositorio<T> {

    private File archivo;

    public RepositorioArchivo(String nombreArchivo) {

        this.archivo = new File(nombreArchivo);
    }

    @Override
    public void guardar(List<T> elementos) {
        // try-with-resources versión más moderna y segura del try-catch tradicional.
        // try-with-resources permite abrir recursos que Java cerrará automáticamente
        try (
        // Cualquier objeto que implemente: Closeable AutoCloseable
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream(archivo))

        ) {

            // Guarda la lista completa en el archivo
            oos.writeObject(elementos);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public List<T> consultar() {

        // Si el archivo no existe
        // devolvemos una lista vacía
        if (!archivo.exists()) {

            return new ArrayList<>();
        }

        try (

                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream(archivo))

        ) {

            // readObject() devuelve Object
            // por eso debemos convertirlo (cast)
            // a List<T>

            return (List<T>) ois.readObject();

        } catch (
                IOException | ClassNotFoundException e) {

            e.printStackTrace();
        }

        // En caso de error devolvemos
        // una lista vacía
        return new ArrayList<>();
    }
}