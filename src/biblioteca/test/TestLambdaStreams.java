package biblioteca.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import biblioteca.dominio.Bibliotecario;
import biblioteca.dominio.Persona;
import biblioteca.dominio.Usuario;

public class TestLambdaStreams {

    public static void main(String[] args) {

        // ============================
        // OBJETOS DEL DOMINIO
        // ============================

        Usuario ana = new Usuario("Ana", "Ruiz", 17, 4564537);

        Usuario luis = new Usuario("Luis", "Perez", 25, 45645371);

        Bibliotecario bibliotecario = new Bibliotecario(
                "Juan",
                "Gonzalez",
                45,
                46574738);

        Usuario p1 = new Usuario(
                "Julio",
                "Quintana",
                
                34,
                234344);

        // ============================
        // SET
        // ============================

        // Set NO permite elementos repetidos
        // HashSet utiliza equals() y hashCode()
        // para determinar igualdad lógica

        Set<Persona> personas = new HashSet<>();

        personas.add(bibliotecario);
        personas.add(ana);
        personas.add(luis);
        personas.add(p1);

        // ============================
        // LIST
        // ============================

        // List mantiene el orden de inserción
        // y permite repetidos

        List<Persona> listPersonas = new ArrayList<>();

        listPersonas.add(ana);
        listPersonas.add(bibliotecario);
        listPersonas.add(luis);

        // ============================
        // PREDICATE
        // ============================

        // Predicate representa una condición
        // T -> boolean

        Predicate<Persona> mayorEdad = p -> p.getEdad() >= 18;

        // test() evalúa la condición
        // System.out.println(mayorEdad.test(ana));

        // ============================
        // CONSUMER
        // ============================

        // Consumer recibe un objeto
        // pero no devuelve nada
        // T -> void

        Consumer<Persona> mostrar = p -> System.out.println(p);

        // accept() ejecuta la acción
        // mostrar.accept(bibliotecario);

        // ============================
        // FUNCTION
        // ============================

        // Function transforma un dato en otro
        // T -> R

        Function<Persona, String> obtenerNombre = p -> p.getNombre();

        // apply() ejecuta la transformación
        // System.out.println(obtenerNombre.apply(luis));

        // ============================
        // SUPPLIER
        // ============================

        // Supplier genera/provee objetos
        // () -> T

        Supplier<Usuario> crearUsuario = () -> new Usuario(
                "Nuevo",
                "Usuario",
                
                20,
                324856);

        Usuario u = crearUsuario.get();

        // mostrar.accept(u);

        // ============================
        // STREAM API
        // ============================

        // Stream permite procesar colecciones
        // de forma declarativa

        personas.stream()
                .filter(p -> p.getEdad() > 18) // filter utiliza un Predicate // Filtra personas mayores de edad
                .map(p -> p.getNombre()) // map transforma objetos // Persona -> String
                .forEach(System.out::println); // forEach consume cada elemento

        listPersonas.stream()
                .sorted(
                        (p, p2) -> Integer.compare(
                                p1.getEdad(),
                                p2.getEdad()))
                .forEach(System.out::println);

        long cantidad = personas.stream()
                .filter(p -> p.getEdad() >= 18)
                .count(); // Operación terminal que devuelve cantidad

        System.out.println("Personas mayores a 18 años: " + cantidad);

        List<String> nombres = personas.stream()
                .map(p -> p.getNombre())
                .collect(Collectors.toList()); // transforma el Stream en una colección

        System.out.println(nombres);
    }

}