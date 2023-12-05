package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EjemploRead {

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

    // Método para obtener un registro por su ID
    public void obtenerRegistroPorId(int id) {
        Connection conn = null; // Mueve la declaración aquí

        // Obtener la conexión a la base de datos (se asume que ya está establecida)
        try {
            conn = obtenerConexion(); // Inicializa la variable aquí

            // Definir la sentencia SQL con un placeholder (?) para el ID
            String sql = "SELECT * FROM tabla_usuarios WHERE id = ?";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                // Establecer el valor del ID en el PreparedStatement
                stmt.setInt(1, id);

                // Ejecutar la consulta y obtener el resultado en un ResultSet
                try (ResultSet rs = stmt.executeQuery()) {
                    // Iterar sobre los registros devueltos por el ResultSet
                    while (rs.next()) {
                        int registroId = rs.getInt("id");
                        String nombre = rs.getString("nombre");
                        int edad = rs.getInt("edad");

                        System.out.println("ID: " + registroId);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Edad: " + edad);
                        System.out.println("--------------------------");
                    }
                }
            }
        } catch (SQLException e) {
            // Manejo de excepciones (puedes imprimir o registrar el error)
            System.out.println("Error al obtener el registro: " + e.getMessage());
        } finally {
            cerrarConexion(conn); // Cierra la conexión en el bloque finally
        }
    }

    // Método para cerrar la conexión
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
