package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {

    // Método para obtener una conexión a la base de datos MySQL
    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            // Cargar el controlador JDBC para MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión con la base de datos
            String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
            String user = "usuario";
            String password = "contrasena";
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Manejo básico de excepciones (ajústalo según tus necesidades)
        }
        return connection;
    }
}
