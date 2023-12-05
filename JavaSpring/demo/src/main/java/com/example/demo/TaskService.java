package com.example.demo;

import java.util.List;

public interface TaskService {
    void addTask(Task task);
    Task getTask(Long id);
    List<Task> listTasks();
}
