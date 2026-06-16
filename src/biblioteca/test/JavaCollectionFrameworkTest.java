package biblioteca.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import biblioteca.dominio.Biblioteca;
import biblioteca.dominio.Bibliotecario;
import biblioteca.dominio.Persona;
import biblioteca.dominio.Usuario;
import biblioteca.util.CompararPorApellido;

public class JavaCollectionFrameworkTest {

    public static void main(String[] args) {

        Usuario ana = new Usuario("Ana", "Ruiz", 24, 235456);
        Usuario luis = new Usuario("Luis", "Perez", 25, 38475656);

        Bibliotecario bibliotecario = new Bibliotecario("Juan", "Gonzalez", 45, 273646);

        // LIST

        // List mantiene el orden de inserción
        // y permite elementos repetidos
        List<Persona> listPersonas = new ArrayList<>();

        listPersonas.add(ana);
        listPersonas.add(bibliotecario);
        listPersonas.add(luis);

        // remove elimina por índice
        // listPersonas.remove(3);

        // size() devuelve la cantidad de elementos

        // Recorrido con for tradicional
        for (int i = 0; i < listPersonas.size(); i++) {

            // get(i) obtiene el elemento en la posición i
            // System.out.println(listPersonas.get(i));
        }

        // clear() elimina todos los elementos
        // listPersonas.clear();

        // SET

        // Set NO permite repetidos
        // HashSet no garantiza el orden
        Set<Persona> hashPersonas = new HashSet<>();

        hashPersonas.add(ana);
        hashPersonas.add(bibliotecario);
        hashPersonas.add(luis);
        hashPersonas.add(luis);

        // remove elimina un objeto del Set
        // hashPersonas.remove(bibliotecario);

        // Recorrido con for-each
        for (Persona p : hashPersonas) {

            // System.out.println(p);
        }

        // MAP

        // Map trabaja con clave - valor
        HashMap<Integer, Usuario> usuarios = new HashMap<>();

        // put(clave, valor)
        usuarios.put(1, ana);

        // get(clave)
        // System.out.println(usuarios.get(1));

        // ITERATOR

        // Iterator permite recorrer una colección
        // elemento por elemento
        Iterator<Persona> it = listPersonas.iterator();

        while (it.hasNext()) {

            // next() obtiene el siguiente elemento
            Persona p = it.next();

            // equals compara objetos lógicamente
            if (p.equals(ana)) {

                // remove elimina de forma segura
                // durante el recorrido
                // it.remove();
            }
        }

        // System.out.println(listPersonas);

        // COLLECTIONS

        List<String> nombres = new ArrayList<>();

        nombres.add("Juan");
        nombres.add("Ana");
        nombres.add("Luis");

        // sort ordena la lista
        Collections.sort(nombres);

        // reverse invierte el orden actual
        Collections.reverse(nombres);

        // System.out.println(nombres);

        // ARRAYS + WRAPPERS

        // Arrays.asList permite inicializar una lista rápidamente
        // Integer es un Wrapper de int
        List<Integer> numeros = new ArrayList<>(Arrays.asList(5, 3, 7, 5, 1));

        Collections.sort(numeros);

        // System.out.println(numeros);

        // java no sabe ordenar Persona se implementa comparable y se sobreescribe
        // compareTo

        Collections.sort(listPersonas);

        // System.out.println(listPersonas);

        // COMPARATOR (clase separada)

        // Comparator permite definir distintos criterios de orden
        Collections.sort(listPersonas, new CompararPorApellido());

        // clase anonima 
        //Comparator<Persona> compararEdad = new Comparator<Persona>() {

          //  @Override
            //public int compare(Persona p1, Persona p2) {
              //  return Integer.compare(
                //        p1.getEdad(),
                  //      p2.getEdad());
           // }
        //};
        
        //Collections.sort(listPersonas, compararEdad);

        // System.out.println(listPersonas);

        Collections.sort(listPersonas, (p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()));

        System.out.println(listPersonas);
        // (parametros) -> exprexion

        

    }
}