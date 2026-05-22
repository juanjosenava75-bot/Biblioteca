package biblioteca.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import biblioteca.dominio.Biblioteca;
import biblioteca.dominio.Bibliotecario;
import biblioteca.dominio.Cd;
import biblioteca.dominio.Estado;
import biblioteca.dominio.Libro;
import biblioteca.dominio.Material;
import biblioteca.dominio.MaterialNoDisponibleException;
import biblioteca.dominio.Persona;
import biblioteca.dominio.IPrestable;
import biblioteca.dominio.Revista;
import biblioteca.dominio.Usuario;
import biblioteca.util.Calculadora;

public class Main {
  public static void main(String[] args) {

    Biblioteca b = new Biblioteca();

    // HERENCIA
    // Usuario y Bibliotecario heredan de Persona
    Usuario ana = new Usuario("Ana", "Ruiz", 3,22,3645364);
    Usuario luis = new Usuario("Luis", "Perez", 4,23,35463747);
    Bibliotecario bibliotecario = new Bibliotecario("Juan", "Gonzalez",25,3465657);

    // OBJETOS CONCRETOS
    Libro libro1 = new Libro("1984", "George Orwell");
    // bibliotecario.registrarMaterial(libro1);

    Libro libro2 = new Libro("El Principito", "Antoine de Saint-Exupéry");

    // POLIMORFISMO
    // Guardamos un Libro en una variable de tipo Material
    // Solo podemos acceder a métodos definidos en Material
    Material libro3 = new Libro("Cien años de soledad", "Gabriel García Márquez");

    Revista revista1 = new Revista("National Geographic", "Varios");
    // bibliotecario.registrarMaterial(revista1);

    Cd cd1 = new Cd("El Ritual", "Los Pericos");
    // bibliotecario.registrarMaterial(cd1);

    // RELACIONES (asociación)
    b.agregarPersona(ana);
    b.agregarPersona(luis);
    b.agregarPersona(bibliotecario);

    b.agregarMaterial(libro1);
    b.agregarMaterial(libro2);
    b.agregarMaterial(libro3);
    b.agregarMaterial(revista1);
    b.agregarMaterial(cd1);

    // USO DE MÉTODOS (comportamiento)

    try {
      ana.prestarMaterial(libro1);

      ana.prestarMaterial(cd1);

      luis.prestarMaterial(libro2);
      luis.prestarMaterial(libro3);
      luis.prestarMaterial(revista1);
      luis.prestarMaterial(cd1);
    } catch (MaterialNoDisponibleException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());

    }

    // ESTADO GENERAL DEL SISTEMA
     b.mostrarEstado();

    
    
    


  }

}
