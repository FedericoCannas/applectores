package Main;

import Servicio.Aplicacion;
import Servicio.LibroServicio;

public class LibreriaMain {

    public static void main(String[] args) {

//        LibreriaDigital libreria = new LibreriaDigital();
        Aplicacion aplicacion = new Aplicacion();

        try {

            

            
            LibroServicio book = new LibroServicio();
            book.crearLibro();

//            libreria.ejecutarMenu();
        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }
}
