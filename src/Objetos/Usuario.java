package Objetos;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    
    @Column
    protected String nombre;
    protected String apellido;
    protected String direccion;
    protected String localidad;
    protected int edad;
    protected String correoElectronico;
    
    protected int puntosValoracion;//Cada cierta cantidad de puntos el usuario tiene beneficios.

    protected ArrayList<String> generosFavoritos;
    protected ArrayList<String> LibrosFavoritos;
    protected ArrayList<String> historialComentarios;

    protected ArrayList<Libro> historialBusqueda;

    protected String usuario; //Chequear la seguridad de usuario y contraseña ver metodos seguros.
    protected String contrasenia;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String direccion, String localidad, int edad, String correoElectronico, int puntosValoracion, ArrayList<String> generosFavoritos, ArrayList<String> LibrosFavoritos, ArrayList<String> historialComentarios, ArrayList<Libro> historialBusqueda, String usuario, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.localidad = localidad;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.puntosValoracion = puntosValoracion;
        this.generosFavoritos = generosFavoritos;
        this.LibrosFavoritos = LibrosFavoritos;
        this.historialComentarios = historialComentarios;
        this.historialBusqueda = historialBusqueda;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getPuntosValoracion() {
        return puntosValoracion;
    }

    public void setPuntosValoracion(int puntosValoracion) {
        this.puntosValoracion = puntosValoracion;
    }

    public ArrayList<String> getGenerosFavoritos() {
        return generosFavoritos;
    }

    public void setGenerosFavoritos(ArrayList<String> generosFavoritos) {
        this.generosFavoritos = generosFavoritos;
    }

    public ArrayList<String> getLibrosFavoritos() {
        return LibrosFavoritos;
    }

    public void setLibrosFavoritos(ArrayList<String> LibrosFavoritos) {
        this.LibrosFavoritos = LibrosFavoritos;
    }

    public ArrayList<String> getHistorialComentarios() {
        return historialComentarios;
    }

    public void setHistorialComentarios(ArrayList<String> historialComentarios) {
        this.historialComentarios = historialComentarios;
    }

    public ArrayList<Libro> getHistorialBusqueda() {
        return historialBusqueda;
    }

    public void setHistorialBusqueda(ArrayList<Libro> historialBusqueda) {
        this.historialBusqueda = historialBusqueda;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return " Usuario{" + "nombre= " + nombre +
                "\n apellido= " + apellido +
                "\n direccion= " + direccion + 
                "\n localidad= " + localidad +
                "\n edad= " + edad +
                "\n correoElectronico= " + correoElectronico +
                "\n puntosValoracion= " + puntosValoracion +
                "\n generosFavoritos= " + generosFavoritos +
                "\n LibrosFavoritos= " + LibrosFavoritos +
                "\n historialComentarios= " + historialComentarios +
                "\n historialBusqueda= " + historialBusqueda +
                "\n Usuario= " + usuario +
                "\n Contraseña= " + contrasenia;
    }  
}
