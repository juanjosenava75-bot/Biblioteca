package biblioteca.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import biblioteca.dominio.Usuario;

public class TestArchivos {

    public static void main(String[] args) {

        // Texto FileReader/ FileWriter leer y escribir texto
        // Binario FileInputStream FileOutputStream lee y Escribe binarios
        // Eficiencia BufferedReader / BufferedWriter mejoran el rendimiento
        // Serializacion ObjctInputStream / ObjectOutputStream guarda objetos

        // File archivo = new File ("datos.txt") ;

        // System.out.println(archivo.getAbsolutePath());
        // System.out.println(archivo.exists());

        // try {
        // FileWriter writer = new FileWriter("datos.txt");
        // writer.write("Hola Mundo");
        // writer.close();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // try {
        // FileReader reader = new FileReader("datos.txt");
        // int caracter;
        // while ((caracter = reader.read()) != -1) {

        // System.out.println((char) caracter);

        // }

        // reader.close();

        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // try {
        // BufferedWriter bw = new BufferedWriter(new FileWriter("datos.txt"));
        // bw.write("Linea 1");
        // bw.newLine();
        // bw.write("Linea 2");
        // bw.close();

        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // try {
        // BufferedReader br = new BufferedReader(new FileReader("datos.txt"));
        // String linea;

        // while ((linea = br.readLine()) != null){

        // System.out.println(linea);
        // }

        // br.close();

        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // try {
        // BufferedOutputStream bos = new BufferedOutputStream(new
        // FileOutputStream("archivo.bin"));
        // bos.write(65);
        // bos.close();

        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // try {
        // BufferedInputStream bis = new BufferedInputStream(new
        // FileInputStream("archivo.bin"));
        // int dato;
        // while ((dato = bis.read()) != -1){
        // System.out.println((char)dato);
        // }
        // bis.close();

        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        // try {
        // ObjectOutputStream oos = new ObjectOutputStream(new
        // FileOutputStream("usuario.dat"));

        // oos.writeObject(new Usuario("Juan", "Navarro", 45, 345));
        // oos.close();

        // } catch (FileNotFoundException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuario.dat"));
            Usuario u = (Usuario) ois.readObject();
            System.out.println(u.getApellido());

            ois.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
