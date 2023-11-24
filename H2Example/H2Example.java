package H2Example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class H2Example {
    public static void main(String[] args) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "username", "password");

            // Crear una declaración SQL
            Statement statement = connection.createStatement();

            // Crear la tabla
            String createTableQuery = "CREATE TABLE IF NOT EXISTS usuarios (id INT PRIMARY KEY, nombre VARCHAR(50))";
            statement.executeUpdate(createTableQuery);

            // Insertar registros
            String insertQuery = "INSERT INTO usuarios VALUES (1, 'John Doe'), (2, 'Jane Smith')";
            statement.executeUpdate(insertQuery);

            // Cerrar la conexión
            statement.close();
            connection.close();

            System.out.println("Registros insertados con éxito en la tabla 'usuarios'.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}