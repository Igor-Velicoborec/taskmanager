package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;

import java.util.List;

public interface TaskService {

    void createTask(Task task);

    Task updateTask(Task task);

    void deleteTask(long taskId);

    List<Task> getAllTask();
}
