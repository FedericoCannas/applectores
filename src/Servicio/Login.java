package Servicio;

import Objetos.Usuario;
import Servicio.LibreriaDigital;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    //Metodo Logeo de usuario
    public Usuario creacionUsuario() {
    Usuario user1 = null;

    String correo = JOptionPane.showInputDialog(null, "Ingrese su correo electrónico:");

    if (validarCorreoElectronico(correo)) {
        user1 = new Usuario() {};

        user1.setCorreoElectronico(correo);
        user1.setUsuario(user1.getCorreoElectronico());

        String contrasenia = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
        user1.setContrasenia(contrasenia);

        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre:");
        user1.setNombre(nombre);

        String apellido = JOptionPane.showInputDialog(null, "Ingrese su apellido:");
        user1.setApellido(apellido);

        String edadStr = JOptionPane.showInputDialog(null, "Ingrese su edad:");
        int edad = Integer.parseInt(edadStr);
        user1.setEdad(edad);

        String direccion = JOptionPane.showInputDialog(null, "Ingrese su dirección:");
        user1.setDireccion(direccion);

        String localidad = JOptionPane.showInputDialog(null, "Ingrese su localidad:");
        user1.setLocalidad(localidad);

        // Agregar el usuario a un ArrayList o realizar alguna otra acción
    } else {
        JOptionPane.showMessageDialog(null, "El correo electrónico es inválido.");
    }

    return user1;
}


    public Login() {
    }

    public Scanner getLeer() {
        return leer;
    }

    public void setLeer(Scanner leer) {
        this.leer = leer;
    }


public boolean metodoLogin(ArrayList<Usuario> usuarios, LibreriaDigital libreria) {
    while (true) {
        JPasswordField passwordField = new JPasswordField();
        JTextField userField = new JTextField();

        Object[] message = {
            "Usuario:", userField,
            "Contraseña:", passwordField
        };

        int option = JOptionPane.showOptionDialog(
            null,
            message,
            "Inicio de sesión",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            new Object[]{"Iniciar sesión", "Volver al menú principal"},
            null
        );

        if (option == 0) {
            String usuario = userField.getText();
            String contrasenia = new String(passwordField.getPassword());

            if (autenticarUsuario(usuario, contrasenia, usuarios)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Intente nuevamente.");
            }
        } else {
            System.out.println("Volviendo al menú principal");
            libreria.ejecutarMenu(); // Llama al método obtenerOpcion() de la instancia de LibreriaDigital
            return false;
        }
    }
}




    private boolean validarCorreoElectronico(String correo) {
        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(patron, correo);
    }

    private boolean autenticarUsuario(String usuario, String contrasenia, ArrayList<Usuario> usuarios) {

        for (Usuario user : usuarios) {
            if (user.getUsuario().equals(usuario) && user.getContrasenia().equals(contrasenia)) {
                return true; // El usuario y la contraseña coinciden, autenticación exitosa
            }
        }
        return false; // No se encontró un usuario con las credenciales proporcionadas
    }

    //Autenticador contraseña********************Acordate!!!
}
