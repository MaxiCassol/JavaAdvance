package com.example.demo;

import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
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
