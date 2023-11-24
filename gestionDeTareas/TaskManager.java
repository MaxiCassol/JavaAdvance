package gestionDeTareas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {
    private List<String> taskList;

    public TaskManager() {
        taskList = new ArrayList<>();
    }

    public void addTask(String task) {
        taskList.add(task);
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < taskList.size()) {
            // Marcar tarea como completada
            System.out.println("Tarea marcada como completada: " + taskList.get(index));
        } else {
            System.out.println("Índice de tarea no válido");
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
            System.out.println("Tarea eliminada");
        } else {
            System.out.println("Índice de tarea no válido");
        }
    }

    public void printTaskList() {
        System.out.println("Lista de tareas:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i));
        }
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Agregar tareas
        taskManager.addTask("Hacer la compra");
        taskManager.addTask("Estudiar para el examen");
        taskManager.addTask("Hacer ejercicio");

        // Marcar tarea como completada
        taskManager.markTaskAsCompleted(1);

        // Eliminar tarea
        taskManager.removeTask(0);

        // Mostrar lista de tareas
        taskManager.printTaskList();

        // Verificar si una tarea está en la lista
        System.out.println("¿Contiene 'Estudiar para el examen'? " + taskManager.taskList.contains("Estudiar para el examen"));

        // Verificar si la lista de tareas está vacía
        System.out.println("¿La lista de tareas está vacía? " + taskManager.taskList.isEmpty());

        // Ordenar las tareas alfabéticamente
        Collections.sort(taskManager.taskList);

        // Obtener un arreglo de las tareas
        String[] tasksArray = taskManager.taskList.toArray(new String[0]);
        System.out.println("Arreglo de tareas:");
        for (String task : tasksArray) {
            System.out.println(task);
        }
    }
}

