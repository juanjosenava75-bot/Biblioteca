package biblioteca.test;

import biblioteca.dominio.Cd;
import biblioteca.dominio.IPrestable;
import biblioteca.dominio.Libro;
import biblioteca.dominio.Material;
import biblioteca.dominio.Revista;

public class TestPolimorfismo {

    public static void main(String[] args) {
        // POLIMORFISMO CON ARREGLOS

        Material[] material = new Material[3];

        material[0] = new Libro("El Gaucho Martín Fierro", "José Hernández");
        material[1] = new Revista("La Nacion Revista", "Grupo Nacion");
        material[2] = new Cd("La Nave", "Los Ratones Paranoicos");

        // MISMA referencia (Material)
        // DISTINTO comportamiento (override)
        for (Material m : material) {
            m.mostrarInfo(); // se ejecuta el método del objeto real
        }

        // INTERFACES + POLIMORFISMO

        IPrestable[] prestable = new IPrestable[3];
        Libro libro = new Libro("El Principito", "Antoine de Saint-Exupéry");
        Revista revista1 = new Revista("National Geographic", "Varios");

        // Distintos tipos, mismo comportamiento
        prestable[0] = libro;
        prestable[1] = revista1;
        prestable[2] = new Cd("Boleros", "Luis Miguel");

        // Trabajamos con el coportamiento (interface), no con la clase
        for (IPrestable p : prestable) {
            p.prestar(); // todas las clases implementan este método
            p.devolver();
        }

        // Si queremos acceder a métodos específicos:
        Material libro3 = new Libro("Cien años de soledad", "Gabriel García Márquez");
        if (libro3 instanceof Libro) {
            Libro l = (Libro) libro3;
            l.leer(); // método propio de Libro
        }

        // El cast NO cambia el objeto, solo cómo lo tratamos

    }

}
