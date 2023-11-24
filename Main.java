import ajedrez.PiezasAjedrez;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import persona.Persona;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

//
        // Ajedrez:
        PiezasAjedrez Caballo = new PiezasAjedrez("1 y 1", "de frente y en diagonal");
        System.out.println(Caballo.getDireccionDeMovimiento() + " " + Caballo.getCantidadDeCasillasAvanza());
        PiezasAjedrez Alfil = new PiezasAjedrez("cuantas casillas quiera", "mueve en diagonal");
        System.out.println(Alfil.getDireccionDeMovimiento() + " " + Alfil.getCantidadDeCasillasAvanza());

// Configurar los parámetros de conexión
        String url = "jdbc:h2:~/test"; // URL de conexión a la base de datos H2
        String username = "usuario"; // Nombre de usuario de la base de datos
        String password = "contraseña"; // Contraseña de la base de datos

        try {
            // Establecer la conexión
            Connection connection = DriverManager.getConnection(url, username, password);

            // Realizar operaciones en la base de datos

            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}






