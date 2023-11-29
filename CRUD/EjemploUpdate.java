package CRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EjemploUpdate {

    // Método para actualizar un registro por su ID
    public void actualizarRegistroPorId(int id, String nuevoNombre, int nuevaEdad) {
        // Obtener la conexión a la base de datos (se asume que ya está establecida)
        Connection conn = obtenerConexion();

        // Definir la sentencia SQL con los placeholders (?) para los nuevos valores
        String sql = "UPDATE tabla_usuarios SET nombre = ?, edad = ? WHERE id = ?";

        try {
            // Crear un PreparedStatement a partir de la sentencia SQL
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Establecer los nuevos valores en el PreparedStatement
            stmt.setString(1, nuevoNombre);
            stmt.setInt(2, nuevaEdad);
            stmt.setInt(3, id);

            // Ejecutar la actualización
            int filasAfectadas = stmt.executeUpdate();

            // Verificar si la actualización fue exitosa
            if (filasAfectadas > 0) {
                System.out.println("El registro se actualizó exitosamente.");
            } else {
                System.out.println("No se encontró el registro especificado.");
            }

            // Cerrar el PreparedStatement
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el registro: " + e.getMessage());
        } finally {
            // Cerrar la conexión a la base de datos
            cerrarConexion(conn);
        }
    }

    // Método para obtener la conexión a la base de datos
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

    // Método para cerrar la conexión a la base de datos
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