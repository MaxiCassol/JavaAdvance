package com.example.demo.repository;

import org.springframework.scheduling.config.Task;

import java.util.List;

public interface TaskRepository {
    void save(Task task);
    Task findById(Long id);
    List<Task> findAll();
}

