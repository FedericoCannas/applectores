package Servicio;

import Main.LibreriaMain;
import Interfaz.IordenLibros;
import Objetos.Libro;
import Objetos.Usuario;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import javax.swing.JOptionPane;

public class LibreriaDigital implements IordenLibros {

    Tienda tienda = new Tienda();
    private boolean disponibilidad;
    private int stock;
    private ArrayList<Libro> libros;
    ArrayList<Usuario> usuarios = new ArrayList<>();

    LibreriaMain libreria = new LibreriaMain();

    Login log1 = new Login();
    Usuario user = new Usuario("Frederic", "Canes",
            "Bartolome mitre 1228", "Moron", 37,
            "fede2134@hotmail.com", 5,
            null, null, null,
            null, "fede2134@hotmail.com", "123456") {
    };

    public void mostrarLibros() {
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public class ComparadorTitulo implements Comparator<Libro> {
        @Override
        public int compare(Libro libro1, Libro libro2) {
            return libro1.getTitulo().compareTo(libro2.getTitulo());
        }
    }

    public class ComparadorPrecio implements Comparator<Libro> {
        @Override
        public int compare(Libro libro1, Libro libro2) {
            return Double.compare(libro1.getPrecio(), libro2.getPrecio());
        }
    }

    public class ComparadorAutor implements Comparator<Libro> { //

        @Override
        public int compare(Libro libro1, Libro libro2) {
            return libro1.getAutor().getAutorLibro().compareTo(libro2.getAutor().getAutorLibro());
        }
    }

    public class ComparadorGenero implements Comparator<Libro> {

        @Override
        public int compare(Libro libro1, Libro libro2) {
            return libro1.getGenero().compareTo(libro2.getGenero());
        }
    }

    public class ComparadorEditorial implements Comparator<Libro> {

        @Override
        public int compare(Libro libro1, Libro libro2) {
            return libro1.getEditorial().getEditorial().compareTo(libro2.getEditorial().getEditorial());
        }
    }

    public class ComparadorIdioma implements Comparator<Libro> {

        @Override
        public int compare(Libro libro1, Libro libro2) {
            return libro1.getIdioma().compareTo(libro2.getIdioma());
        }
    }

    public class ComparadorEdicion implements Comparator<Libro> {

        @Override
        public int compare(Libro libro1, Libro libro2) {
            String edicion1 = Integer.toString(libro1.getEdicion());
            String edicion2 = Integer.toString(libro2.getEdicion());
            return edicion1.compareTo(edicion2);
        }
    }

    public class ComparadorOrigen implements Comparator<Libro> {

        @Override
        public int compare(Libro libro1, Libro libro2) {
            return libro1.getOrigen().compareTo(libro2.getOrigen());
        }
    }

    public class ComparadorPeso implements Comparator<Libro> {

        @Override
        public int compare(Libro libro1, Libro libro2) {
            return Double.compare(libro1.getPeso(), libro2.getPeso());
        }
    }

    @Override
    public void ordenAlfabeticoTitulo() {
        Collections.sort(libros, new ComparadorTitulo());
    } // Orden por titulo

    @Override
    public void ordenPrecio() {
        Collections.sort(libros, new ComparadorPrecio());
    } // Orden por precio

    @Override
    public void ordenAutor() {
        Collections.sort(libros, new ComparadorAutor());
    } // Orden por autor

    @Override
    public void mostrarUsados() {
        for (Libro libro : libros) {
            if (libro.getUsado() == true) {
                System.out.println(libro);
            }
        }
    } //Mostrar los libros usados

    @Override
    public void ordenGenero() {
        Collections.sort(libros, new ComparadorGenero());
    }

    @Override
    public void ordenCalificacion() {
        //chequear la calificacion donde va.------------------------------------
    }

    @Override
    public void ordenEditorial() {
        Collections.sort(libros, new ComparadorEditorial());
    } // Orden por editorial

    @Override
    public void ordenIdioma() {
        Collections.sort(libros, new ComparadorIdioma());
    } // Orden por Idioma

    @Override
    public void ordenEdicion() {
        Collections.sort(libros, new ComparadorEdicion());
    } //Orden por edicion

    @Override
    public void ordenOrigen() {
        Collections.sort(libros, new ComparadorOrigen());
    } // Orden por origen

    @Override
    public void ordenPeso() {
        Collections.sort(libros, new ComparadorPeso());
    } // Orden por peso.

    @Override
    public void libreriasQueLoVenden() {
        //Chequear las mecanicas de las librerias que los venden.... A desarrollar
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void ejecutarMenu() {
        boolean salir = false;
        Usuario user = null;
        while (!salir) {
            try {
                mostrarTituloMenu();
                int opcion = obtenerOpcion();

                switch (opcion) {
                    case 1:
                        user = log1.creacionUsuario();
                        if (user != null) {
                            usuarios.add(user);
                            mostrarMensaje("¡Cuenta creada exitosamente!");
                        }
                        break;
                    case 2:
                        boolean autenticado = log1.metodoLogin(usuarios, this);
                        if (autenticado) {
                            mostrarMensaje("¡Bienvenido, " + user.getNombre() + "!");
                            tienda.menuLibros();
                        }
                        break;
                    case 3:
                        salir = true;
                        mostrarMensaje("¡Hasta luego!");
                        break;
                    default:
                        mostrarMensaje("Opción inválida. Intente nuevamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                mostrarMensaje("Carácter inválido. Intente nuevamente.");
                // No se necesita limpiar el búfer de entrada en una interfaz gráfica
            }
            mostrarSeparador();
        }
    }

    private void mostrarTituloMenu() {
        JOptionPane.showMessageDialog(null, "----- Bienvenido a Librería Digital! -----");
    }

    private int obtenerOpcion() {
        String opcionStr = JOptionPane.showInputDialog(null, "Seleccione una opción:\n"
                + "1. Crear cuenta\n"
                + "2. Iniciar sesión\n"
                + "3. Salir");

        try {
            return Integer.parseInt(opcionStr);
        } catch (NumberFormatException e) {
            return -1; // Valor inválido
        }
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private void mostrarSeparador() {
        JOptionPane.showMessageDialog(null, "---------------------------------------");
    }

    public LibreriaMain getLibreria() {
        return libreria;
    }

    public void setLibreria(LibreriaMain libreria) {
        this.libreria = libreria;
    }

    public Login getLog1() {
        return log1;
    }

    public void setLog1(Login log1) {
        this.log1 = log1;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

}
