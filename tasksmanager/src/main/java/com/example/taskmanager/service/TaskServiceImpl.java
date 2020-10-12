package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public void createTask(Task task) {
        taskRepository.save(task);


    }



    public Optional getTask(long taskId) {

        return taskRepository.findById(taskId) ;
    }

    @Override
    public Task updateTask(Task task) {
        return null;
    }

    @Override
    public void deleteTask(long taskId) {
        taskRepository.deleteById(taskId);

    }

    @Override
        public List<Task>  getAllTask() {
        return taskRepository.findAll();
    }




}
