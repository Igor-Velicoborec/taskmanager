package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;

import java.util.List;

public interface TaskService {

    Task getById(Long id);

    void save(Task task);

    Task updateTask(Task task);

    void deleteTask(long id);

    List<Task> getAll();
}
