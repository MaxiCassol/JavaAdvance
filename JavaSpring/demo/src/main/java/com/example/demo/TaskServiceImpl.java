package com.example.demo;

import com.example.demo.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    private List<Task> tasks = new ArrayList<>();

    @Override
    public void addTask(Task task) {
        tasks.add(task);
    }

    @Override
    public Task getTask(Long id) {
        // Implementar lógica para obtener una tarea por ID
        return null;
    }

    @Override
    public List<Task> listTasks() {
        return tasks;
    }
}
