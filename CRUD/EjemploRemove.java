package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjemploRemove {

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

    // Método para eliminar un registro por su ID
    public void eliminarRegistroPorId(int id) {
        // Obtener la conexión a la base de datos (se asume que ya está establecida)
        Connection conn = obtenerConexion();

        // Definir la sentencia SQL con el placeholder (?) para el ID
        String sql = "DELETE FROM tabla_usuarios WHERE id = ?";

        try {
            // Crear un PreparedStatement a partir de la sentencia SQL
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Establecer el ID en el PreparedStatement
            stmt.setInt(1, id);

            // Ejecutar la eliminación
            int filasAfectadas = stmt.executeUpdate();

            // Verificar si la eliminación fue exitosa
            if (filasAfectadas > 0) {
                System.out.println("El registro se eliminó exitosamente.");
            } else {
                System.out.println("No se encontró el registro especificado.");
            }

            // Cerrar el PreparedStatement
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el registro: " + e.getMessage());
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