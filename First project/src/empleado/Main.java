package empleado;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        // Insertar empleado
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setNombre("Juan");
        nuevoEmpleado.setSalario(50000.0);
        empleadoDAO.insertarEmpleado(nuevoEmpleado);

        // Actualizar empleado
        Empleado empleadoExistente = new Empleado();
        empleadoExistente.setId(1);  // Suponiendo que el empleado con ID 1 existe
        empleadoExistente.setNombre("Carlos");
        empleadoExistente.setSalario(55000.0);
        empleadoDAO.actualizarEmpleado(empleadoExistente);

        // Eliminar empleado
        int idEmpleadoAEliminar = 2;  // Suponiendo que el empleado con ID 2 existe
        empleadoDAO.eliminarEmpleado(idEmpleadoAEliminar);

        // Obtener y mostrar todos los empleados
        List<Empleado> empleados = empleadoDAO.obtenerTodosLosEmpleados();
        for (Empleado empleado : empleados) {
            System.out.println(empleado);
        }
    }
}
