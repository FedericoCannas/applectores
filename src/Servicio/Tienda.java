package Servicio;

import Objetos.Libro;
import Objetos.Libro;
import Objetos.Usuario;
import Objetos.Usuario;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tienda {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private ArrayList<Libro> libreria = new ArrayList();

    Libro libro1 = new Libro();
    Usuario user = new Usuario() {
    };
    Login log1 = new Login();

    public void buscarPorTitulo() {
        System.out.println("Introduzca el título del libro:");
        String titulo = leer.next();
        boolean encontrado = false;
        for (Libro libro : libreria) {
            if (titulo.equals(libro.getTitulo())) {
                System.out.println(libro);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encuentra el libro. :(");
        }
    }

    public void buscarPorAutor() {
        System.out.println("Introduzca el título del libro:");
        String titulo = leer.next();
        boolean encontrado = false;
        for (Libro libro : libreria) {
            if (titulo.equals(libro.getTitulo())) {
                System.out.println(libro);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encuentra el libro. :(");
        }
    }

    public void mostrarLibros() {
        for (Libro libro : libreria) {
            System.out.println(libro);
        }
    }

    

    public void modificarLibro(){
        
        try {
            
            System.out.println("Introduzca el título del libro que desea modificar:");
            String titulo = leer.next();
            boolean encontrado = false;

            Iterator<Libro> iterator = libreria.iterator();
            while (iterator.hasNext()) {
                Libro libro = iterator.next();
                if (titulo.equals(libro.getTitulo())) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                System.out.println("El libro ha sido eliminado exitosamente.");
            } else {
                System.out.println("No se encontró el libro en la librería.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error al eliminar el libro. Inténtelo nuevamente.");
            menuLibros(); // Volver al menú de libros
        }
    }
    
    
    //Instanceof para mostrar el menu limitado


public void menuLibros() {
    int opcion = 0;
    do {
        String[] opciones = {
            "Mostrar todos los libros",
            "Buscar un libro por título",
            "Buscar un libro por autor",
            "Agregar un nuevo libro",
            "Eliminar un libro existente",
            "Modificar un libro existente",
            "Salir"
        };

        String opcionSeleccionada = (String) JOptionPane.showInputDialog(
            null,
            "**** Bienvenido al mundo de los libros ****",
            "Menú de Libros",
            JOptionPane.PLAIN_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        if (opcionSeleccionada == null) {
            // El usuario cerró la ventana, salir del menú
            break;
        }

        opcion = obtenerOpcion(opcionSeleccionada);

        switch (opcion) {
            
            case 1:
                mostrarLibros();
                break;
            case 2:
                buscarPorTitulo();
                break;
            case 3:
                buscarPorAutor();
                break;
            case 4:
                crearLibro();
                break;
            case 5:
                eliminarLibro();
                break;
            case 6:
                modificarLibro();
                break;
            case 7:
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción inválida. Inténtelo nuevamente.");
        }
    } while (opcion != 7);
}

// Método auxiliar para obtener el número de opción correspondiente al texto seleccionado
private int obtenerOpcion(String opcionSeleccionada) {
    switch (opcionSeleccionada) {
        case "Mostrar todos los libros":
            return 1;
        case "Buscar un libro por título":
            return 2;
        case "Buscar un libro por autor":
            return 3;
        case "Agregar un nuevo libro":
            return 4;
        case "Eliminar un libro existente":
            return 5;
        case "Modificar un libro existente":
            return 6;
        case "Salir":
            return 7;
        default:
            return 0;
    }
}
}
