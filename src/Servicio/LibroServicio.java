package Servicio;

import Objetos.Autor;
import Objetos.Editorial;
import Objetos.Libro;
import java.util.Iterator;
import java.util.Scanner;
import persistencia.LibroDAO;

public class LibroServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearLibro() { //**********************************************
        
        try {

            int anio;
            int mes;
            int dia;

            System.out.println("");
            String opcion = "NO";

            //comprobar que el usuario sea admin
            Libro libro = new Libro();
            LibroDAO libroDAO = new LibroDAO();

            System.out.println("Ingrese el titulo");
            libro.setTitulo(leer.next());

            System.out.println("Ingrese el autor");
            Autor autor= new Autor();
            autor.setAutorLibro(leer.next());
            
            libro.setAutor(autor);

            System.out.println("Ingrese el genero");
            libro.setGenero(leer.next());

            System.out.println("Ingrese el traductor(Si lo tiene)");
            libro.setTraductor(leer.next());

            System.out.println("Ingrese la editorial");
            Editorial editorial=new Editorial();
            editorial.setEditorial(leer.next());
            libro.setEditorial(editorial);

            System.out.println("Ingrese el precio");
            libro.setPrecio(leer.nextDouble());

            System.out.println("Ingrese el peso");
            libro.setPeso(leer.nextDouble());

            System.out.println("Ingrese la edicion");
            libro.setEdicion(leer.nextInt());

            System.out.println("¿El libro es usado?");
            opcion = leer.next().toUpperCase();

            if (opcion.equalsIgnoreCase("SI")) {
                libro.setUsado(true);
            }
            System.out.println("Ingrese el formato");
            libro.setFormato(leer.next());
            
            System.out.println("Ingrese el ISBN");
            libro.setIsbn(leer.next());
            
            System.out.println("Ingrese la cantidad de paginas");
            libro.setCantPaginas(leer.nextInt());

            System.out.println("Ingrese la fecha de salida (formato: día /mes/ año)");
            System.out.print("Dia:");
            dia = Integer.parseInt(leer.next());
            System.out.print("Mes:");
            mes = Integer.parseInt(leer.next());
            System.out.print("Año:");
            anio = Integer.parseInt(leer.next());
            libro.setFechaSalidaLibro(anio, mes, dia);

            System.out.println("Ingrese el origen");
            libro.setOrigen(leer.next());
            
            System.out.println("Ingrese el idioma");
            libro.setIdioma(leer.next());
            
            System.out.println("Ingrese la sinopsis");
            libro.setSinopsis(leer.next());
            
            
            System.out.println("¿El libro esta disponible?");
            opcion = leer.next().toUpperCase();

            if (opcion.equalsIgnoreCase("SI")) {
                libro.setDisponibilidad(true); 
            }

            libroDAO.guardar(libro);

            System.out.println("El libro fue creado con exito!");
//            menuLibros();

        } catch (Exception e) {
            System.out.println("Error en la creacion del libro " + e.getMessage());
//            menuLibros(); // Volver al menú de libros
        }
    }

    public void buscarLibro(){
    
    }
    
    
    
    public void eliminarLibro() {
        try {
            
            System.out.println("Introduzca el título del libro que desea eliminar:");
            
            String titulo = leer.next();
            
            boolean encontrado = false;

            Iterator<Libro> iterator = libreria.iterator();
            
            while (iterator.hasNext()) {
                
                Libro libro = iterator.next();
                
                if (titulo.equals(libro.getTitulo())) {
                    iterator.remove();
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

}
