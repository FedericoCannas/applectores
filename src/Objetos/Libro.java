package Objetos;

import Objetos.Editorial;
import java.io.Serializable;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/*
Esta clase es la clase padre que dara herencia a todos los hijos
revista,manga, etc...
 */
@Entity
@Table(name = "Libro")

public class Libro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String isbn;

    private String titulo;

    @ManyToOne
    private Autor autor;

    private String genero;

    private String traductor;

    @OneToOne
    private Editorial editorial;

    private String formato;

    private String origen;

    private String idioma;

    private String sinopsis;

    private double precio;

    private double peso;

    private int edicion;

    private int cantPaginas;

    private boolean usado;

    @Temporal(TemporalType.DATE)
    private Date fechaSalidaLibro;

    private boolean disponibilidad;

    public Libro() {
        this.disponibilidad = false;
    }

    public Libro(long id, String titulo, Autor autor, String genero,
            String traductor, Editorial editorial, String formato,
            String origen, String idioma, String sinopsis, double precio,
            double peso, int edicion, int cantPaginas, String isbn, boolean usado,
            Date fechaSalidaLibro, boolean disponibilidad) {

        this.disponibilidad = false; // Establece la disponibilidad inicial en falso

        // Validación de precio y peso no negativos
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo"); // Lanza una excepción si el precio es negativo
        }
        this.precio = precio; // Asigna el valor del precio a la propiedad correspondiente

        if (peso < 0) {
            throw new IllegalArgumentException("El peso no puede ser negativo"); // Lanza una excepción si el peso es negativo
        }
        this.peso = peso; // Asigna el valor del peso a la propiedad correspondiente

        // Validación de edicion y cantPaginas mayores a cero
        if (edicion <= 0) {
            throw new IllegalArgumentException("La edición debe ser mayor a cero"); // Lanza una excepción si la edición es menor o igual a cero
        }
        this.edicion = edicion; // Asigna el valor de la edición a la propiedad correspondiente

        if (cantPaginas <= 0) {
            throw new IllegalArgumentException("La cantidad de páginas debe ser mayor a cero"); // Lanza una excepción si la cantidad de páginas es menor o igual a cero
        }
        this.cantPaginas = cantPaginas; // Asigna el valor de la cantidad de páginas a la propiedad correspondiente

        // Validación del formato del ISBN
        if (!validarISBN(isbn)) {
            throw new IllegalArgumentException("El ISBN no es válido"); // Lanza una excepción si el ISBN no es válido
        }
        this.isbn = isbn; // Asigna el valor del ISBN a la propiedad correspondiente

        // Resto de las asignaciones
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.traductor = traductor;
        this.editorial = editorial;
        this.formato = formato;
        this.origen = origen;
        this.idioma = idioma;
        this.sinopsis = sinopsis;
        this.id = id;
        this.usado = usado;
        this.fechaSalidaLibro = fechaSalidaLibro;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTraductor() {
        return traductor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTraductor(String traductor) {
        this.traductor = traductor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public boolean getUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public Date getFechaSalidaLibro() {
        return fechaSalidaLibro;
    }

    public void setFechaSalidaLibro(int anio, int mes, int dia) {
        fechaSalidaLibro = new Date(anio - 1900, mes - 1, dia);
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public static boolean validarISBN(String isbn) {
        // Eliminar guiones y espacios en blanco del ISBN
        String cleanedISBN = isbn.replaceAll("[\\-\\s]", "");

        // Verificar la longitud del ISBN
        if (cleanedISBN.length() != 10 && cleanedISBN.length() != 13) {
            return false;
        }

        // Verificar el formato del ISBN de 10 dígitos
        if (cleanedISBN.length() == 10) {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                char c = cleanedISBN.charAt(i);
                if (!Character.isDigit(c)) {
                    return false;
                }
                sum += (Character.getNumericValue(c) * (10 - i));
            }
            char lastChar = cleanedISBN.charAt(9);
            if (lastChar != 'X' && !Character.isDigit(lastChar)) {
                return false;
            }
            sum += (lastChar == 'X') ? 10 : Character.getNumericValue(lastChar);
            return (sum % 11 == 0);
        }

        // Verificar el formato del ISBN de 13 dígitos
        if (cleanedISBN.length() == 13) {
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                char c = cleanedISBN.charAt(i);
                if (!Character.isDigit(c)) {
                    return false;
                }
                sum += (i % 2 == 0) ? Character.getNumericValue(c) : (Character.getNumericValue(c) * 3);
            }
            char lastChar = cleanedISBN.charAt(12);
            if (!Character.isDigit(lastChar)) {
                return false;
            }
            int checkDigit = (10 - (sum % 10)) % 10;
            return (Character.getNumericValue(lastChar) == checkDigit);
        }

        return false;
    }

//    @Override
//    public String toString() {
//        return " id= "+ id
//                + "Titulo= " + titulo
//                + "\n Autor= " + autor
//                + "\n Genero= " + genero
//                + "\n Editorial= " + editorial
//                + "\n Traductor= " + traductor
//                + "\n Precio= " + precio
//                + "\n Peso= " + peso
//                + "\n Edicion= " + edicion
//                + "\n Usado= " + usado
//                + "\n Formato= " + formato
//                + "\n Isbn= " + isbn
//                + "\n Cantidad de Paginas= " + cantPaginas
//                + "\n Fecha de Salida= " + fechaSalidaLibro
//                + "\n Origen= " + origen
//                + "\n Idioma= " + idioma
//                + "\n Sinopsis= " + sinopsis
//                + "\n Disponibilidad= " + disponibilidad;
//    }
}
