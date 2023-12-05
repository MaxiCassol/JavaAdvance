package empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmpleadoDAO {
    private static final String URL = "jdbc:h2:~/test";  // Cambia la URL según tu configuración
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void insertarEmpleado(Empleado empleado) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Empleados (nombre, salario) VALUES (?, ?)")) {
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setDouble(2, empleado.getSalario());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarEmpleado(Empleado empleado) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Empleados SET nombre=?, salario=? WHERE id=?")) {
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setDouble(2, empleado.getSalario());
            preparedStatement.setInt(3, empleado.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEmpleado(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Empleados WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Empleados")) {
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getInt("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setSalario(resultSet.getDouble("salario"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }
}

