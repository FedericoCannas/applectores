package Servicio;

import Objetos.Autor;
import persistencia.AutorDAO;
import java.util.Scanner;
import javax.persistence.Entity;
import persistencia.DAO;


public class AutorServicio {
 
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");   
    private AutorDAO autorDAO = new AutorDAO();
    private final AutorDAO DAO;

        public AutorServicio() {
        this.DAO = new AutorDAO();
    }
    
    public void crearAutor() {
        try {
            
            Autor autor = new Autor();
            System.out.println("Ingrese el nombre del autor:");
            String nombreAutor = leer.next(); 
            
            autor.setAutorLibro(nombreAutor);
            
            DAO.guardar(autor);
            System.out.println("Autor creado exitosamente!");
            
        } catch (Exception e) {
            
            System.out.println("Error crear autor = " + e.getMessage());
        }
    }

}

//    public Mascota crearMascota(String nombre, String dni) {
//        Mascota mascota = new Mascota();
//        try {
//            mascota.setNombre(nombre);
//            mascota.setDni(dni);
//            DAO.guardar(mascota);
//            return mascota;
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }