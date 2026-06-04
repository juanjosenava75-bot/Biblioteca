package biblioteca.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class UiTest {

// Container Jframe ,Jpanel
//Component JButton , Jlabel, JTexfiel 
// layout  FlowLayout, BordertLayout, GridLayout 

public static void main(String[] args) {
    //boxLayoutEjemplo();
   // flowLayoutEjemplo();
   //borderLayoutEjemplo();
   menu();

}

public static void  flowLayoutEjemplo (){
           JFrame frame = new JFrame("Biblioteca"); //JFrame es el container principal.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        Container contenedor = frame.getContentPane();//contentPane  contenedor real donde se organizan los componentes 

       

        // constantes de alineacion FlowLayout.LEFT .RIGH .CENTER
        // hgap vgap
        //FlowLayout() Coloca componentes en fila Botones alineados




        JPanel panel = new JPanel(new FlowLayout());//JPanel es un container secundario

        JButton botonAgregar = new JButton("Agregar Material");
        JButton botonListar = new JButton("Listar Materiales");

        panel.add(botonAgregar);
        panel.add(botonListar);

        contenedor.add(panel);
        frame.setVisible(true);



    }

public static void  borderLayoutEjemplo (){

     JFrame frame = new JFrame("BorderLayout Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        Container contenedor = frame.getContentPane();
       
       
        //BorderLayout  Divide en 5 regiones (N, S, E, O, Centro)
         contenedor.setLayout(new BorderLayout());
        contenedor.add(new JButton("Norte"), BorderLayout.NORTH);
        contenedor.add(new JButton("Sur"), BorderLayout.SOUTH);
        contenedor.add(new JButton("Este"), BorderLayout.EAST);
        contenedor.add(new JButton("Oeste"), BorderLayout.WEST);
        contenedor.add(new JButton("Centro"), BorderLayout.CENTER);

        frame.setVisible(true);
    }



public static void  boxLayoutEjemplo (){
    JFrame frame = new JFrame("Box Layout Ejemplo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400,300);

     Container  contenedor = frame.getContentPane();

     JPanel panel = new JPanel();

     //Organiza los componentes en una sola fila o columna.
     panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
      
      panel.add(new JButton("boton 1"));
      panel.add(new JButton("boton 2"));
      panel.add(new JButton("boton 3"));

      JMenuBar menuBar = new JMenuBar();

      JMenu menuArchivo = new JMenu("Archivo");
      JMenuItem itemNuevo = new JMenuItem("Nuevo");
      JMenuItem itemAbrir = new JMenuItem("Abrir");
      JMenuItem itemSalir = new JMenuItem("Salir");

      menuArchivo.add(itemNuevo);
      menuArchivo.add(itemAbrir);
      menuArchivo.add(itemSalir);

      menuBar.add(menuArchivo);
      frame.setJMenuBar(menuBar);



      contenedor.add(panel);


    frame.setVisible(true);
}

    public static void menu (){

         JFrame frame = new JFrame("Menú Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemNuevo = new JMenuItem("Nuevo");
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        JMenuItem itemSalir = new JMenuItem("Salir");

        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemAbrir);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);

        menuBar.add(menuArchivo);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }


    


}
