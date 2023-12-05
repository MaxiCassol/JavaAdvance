package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class EjemploInsert {
    // Método para obtener una conexión a la base de datos
    private Connection obtenerConexion() {
        Connection connection = null;
        try {
            // Aquí debes proporcionar la URL de conexión, el usuario y la contraseña de tu base de datos
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_de_datos", "usuario", "contrasena");
        } catch (SQLException e) {
            // Manejo de excepciones (puedes imprimir o registrar el error)
            e.printStackTrace();
        }
        return connection;
    }

    // Método para insertar un nuevo registro en la base de datos
    public void insertarRegistro(String nombre, int edad) {
        // Obtener la conexión a la base de datos (se asume que ya está establecida)
        Connection conn = obtenerConexion();

        String sql = "INSERT INTO tabla_usuarios (nombre, edad) VALUES (?, ?)";

        try {
            // Crear un PreparedStatement a partir de la sentencia SQL
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Establecer los valores en el PreparedStatement
            stmt.setString(1, nombre);
            stmt.setInt(2, edad);

            // Ejecutar la inserción
            stmt.executeUpdate();

            // Cerrar el PreparedStatement
            stmt.close();

            System.out.println("Registro insertado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al insertar el registro: " + e.getMessage());
        } finally {
            // Cerrar la conexión a la base de datos
            cerrarConexion(conn);
        }
    }
    private void cerrarConexion(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}