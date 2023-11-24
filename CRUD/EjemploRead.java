package CRUD;

public class EjemploRead {

    // Método para obtener un registro por su ID
    public void obtenerRegistroPorId(int id) {
        // Obtener la conexión a la base de datos (se asume que ya está establecida)
        Connection conn = obtenerConexion();

        // Definir la sentencia SQL con un placeholder (?) para el ID
        String sql = "SELECT * FROM tabla_usuarios WHERE id = ?";

        try {
            // Crear un PreparedStatement a partir de la sentencia SQL
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Establecer el valor del ID en el PreparedStatement
            stmt.setInt(1, id);

            // Ejecutar la consulta y obtener el resultado en un ResultSet
            ResultSet rs = stmt.executeQuery();

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

            // Cerrar el ResultSet y el PreparedStatement
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el registro: " + e.getMessage());
        } finally {
            // Cerrar la conexión a la base de datos
            cerrarConexion(conn);
        }
    }
}