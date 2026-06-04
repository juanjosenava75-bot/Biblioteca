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
import biblioteca.dominio.Persona;
import biblioteca.dominio.IPrestable;
import biblioteca.dominio.Revista;
import biblioteca.dominio.Usuario;
import biblioteca.excepcion.MaterialNoDisponibleException;
import biblioteca.repositorio.IRepositorio;
import biblioteca.repositorio.RepositorioArchivo;
import biblioteca.ui.Menu;
import biblioteca.util.Calculadora;

public class Main {
  public static void main(String[] args) {

  
     Menu menu = new Menu();
     menu.iniciar(); 


  }

}
