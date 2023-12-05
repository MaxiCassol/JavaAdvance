package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    // Método para obtener una conexión a la base de datos H2
    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            // Cargar el controlador JDBC para H2
            Class.forName("org.h2.Driver");

            // Establecer la conexión con la base de datos (en memoria en este ejemplo)
            String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
            String user = "usuario";
            String password = "contrasena";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones (ajústalo según tus necesidades)
        }
        return connection;
    }
}
