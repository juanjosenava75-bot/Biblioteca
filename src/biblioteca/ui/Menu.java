package biblioteca.ui;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import biblioteca.dominio.Biblioteca;
import biblioteca.dominio.Cd;
import biblioteca.dominio.Estado;
import biblioteca.dominio.Libro;
import biblioteca.dominio.Material;
import biblioteca.dominio.Persona;
import biblioteca.dominio.Revista;
import biblioteca.dominio.Usuario;
import biblioteca.excepcion.MaterialNoDisponibleException;
import biblioteca.repositorio.IRepositorio;
import biblioteca.repositorio.RepositorioArchivo;

public class Menu {
private  Scanner scanner ;
private Biblioteca biblioteca;

    public void iniciar() {

        scanner = new Scanner(System.in);

         biblioteca = new Biblioteca();

        IRepositorio<Persona> repositorioUsuario = new RepositorioArchivo<>("usuario.dat");
        biblioteca.setPersonas(repositorioUsuario.consultar());
        IRepositorio<Material> repositorioMaterial = new RepositorioArchivo<>("material.dat");
        biblioteca.setMaterial((List<Material>) repositorioMaterial.consultar());

        int opcion = -1;

        do {

            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1. Agregar material");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Prestar material");
            System.out.println("4. Mostrar estado");
            System.out.println("5. Mostrar disponible");
            System.out.println("6. Mostrar ordenado");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) { // valida que sea un entero
                opcion = scanner.nextInt();
            } else {

                System.out.println("Debe ingresar una opcion valida");
                scanner.next(); // limpia la entrada invalida
                continue;
            }

            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Agregar material");
                    agregarMaterial();
                    break;

                case 2:
                    registrarUsuario();
                    break;

                case 3:
                    System.out.println("Prestar material");
                    prestarMaterial();
                    break;

                case 4:
                    biblioteca.mostrarEstado();
                    break;

                case 5:

                    mostrarDisponibles();
                    break;

                case 6:
                    mostrarOrdenados();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        repositorioMaterial.guardar(biblioteca.getMaterial());
        repositorioUsuario.guardar(biblioteca.getPersonas());
        scanner.close();

    }

    private void agregarMaterial() {

        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. CD");

        int tipo = this.scanner.nextInt();
        this.scanner.nextLine();

        System.out.print("Titulo: ");
        String titulo = this.scanner.nextLine();

        System.out.print("Autor/Artista: ");
        String autor = this.scanner.nextLine();

        Material material = null;

        switch (tipo) {

            case 1:
                material = new Libro(titulo, autor);
                break;

            case 2:
                material = new Revista(titulo, autor);
                break;

            case 3:
                material = new Cd(titulo, autor);
                break;

            default:
                System.out.println("Tipo inválido");
        }

        if (material != null) {

            this.biblioteca.agregarMaterial(material);
        }

    }

    private void registrarUsuario() {

        System.out.println("\n--- REGISTRAR USUARIO ---");

        System.out.print("Nombre: ");
        String nombre = this.scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = this.scanner.nextLine();

        System.out.print("Edad: ");
        int edad = this.scanner.nextInt();

        System.out.print("DNI: ");
        int dni = this.scanner.nextInt();

        this.scanner.nextLine();

        Usuario usuario = new Usuario(
                nombre,
                apellido,
                edad,
                dni);

        this.biblioteca.agregarPersona(usuario);
    }

    private void prestarMaterial() {

        System.out.println("\n--- PRESTAR MATERIAL ---");

        System.out.print("DNI usuario: ");
        int dni = this.scanner.nextInt();
        this.scanner.nextLine();

        Usuario usuario = this.biblioteca.buscarUsuario(dni);

        if (usuario == null) {

            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.print("Titulo material: ");
        String titulo = this.scanner.nextLine();

        Material material = this.biblioteca.buscarMaterial(titulo);

        if (material == null) {

            System.out.println("Material no encontrado");
            return;
        }

        try {

            usuario.prestarMaterial(material);

            System.out.println(
                    "Prestamo realizado correctamente");

        } catch (MaterialNoDisponibleException e) {

            System.out.println(e.getMessage());
        }
    }

    private void mostrarDisponibles() {

        System.out.println(
                "\n--- MATERIALES DISPONIBLES ---");

        this.biblioteca.getMaterial()
                .stream()
                .filter(m -> m.getEstado().equals(Estado.DISPONIBLE))
                .forEach(System.out::println);
    }

    private void mostrarOrdenados() {

        System.out.println(
                "\n--- MATERIALES ORDENADOS ---");

        this.biblioteca.getMaterial()
                .stream()
                .sorted(
                        (m1, m2) -> m1.getTitulo()
                                .compareTo(
                                        m2.getTitulo()))
                .forEach(System.out::println);
    }
}
