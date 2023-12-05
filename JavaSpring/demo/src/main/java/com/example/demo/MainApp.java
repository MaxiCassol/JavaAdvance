package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Inicio de la aplicación");

        // Cargar el contexto de Spring desde el archivo XML de configuración
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Obtener el bean de TaskService
        TaskService taskService = (TaskService) context.getBean("taskService");

        // Usar TaskService para realizar operaciones con tareas
        Task task1 = new Task(/* ... */);
        taskService.addTask(task1);

        Task task2 = taskService.getTask(1L);

        List<Task> tasks = taskService.listTasks();
        // Realizar otras operaciones según sea necesario
        System.out.println("Fin de la aplicación");
    }
}
