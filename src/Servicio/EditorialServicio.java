package Servicio;

import Objetos.Editorial;
import java.util.Scanner;
import persistencia.EditorialDAO;

public class EditorialServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearEditorial() {

        EditorialDAO editorialDAO = new EditorialDAO();

        try {
            Editorial editorial = new Editorial();
            System.out.println("Ingrese la editorial");
            String nombreEditorial = leer.next();
            editorial.setEditorial(nombreEditorial);

            editorialDAO.guardar(editorial);

            System.out.println("Editorial creada exitosamente!!!");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
