package com.example.demo.repository;

import org.springframework.scheduling.config.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private List<Task> tasks = new ArrayList<>();

    @Override
    public void save(Task task) {
        tasks.add(task);
    }

    @Override
    public Task findById(Long id) {
        // Implementar lógica para encontrar tarea por ID
        return null;
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }
}
