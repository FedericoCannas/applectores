


package Objetos;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class UsuarioCliente extends Usuario{

    public UsuarioCliente() {
    }

    public UsuarioCliente(String nombre, String apellido, String direccion, String localidad, int edad, String correoElectronico, int puntosValoracion, ArrayList<String> generosFavoritos, ArrayList<String> LibrosFavoritos, ArrayList<String> historialComentarios, ArrayList<Libro> historialBusqueda, String usuario, String contrasenia) {
        super(nombre, apellido, direccion, localidad, edad, correoElectronico, puntosValoracion, generosFavoritos, LibrosFavoritos, historialComentarios, historialBusqueda, usuario, contrasenia);
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
    
}
