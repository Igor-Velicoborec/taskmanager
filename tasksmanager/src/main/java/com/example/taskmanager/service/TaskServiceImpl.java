package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskPriority;
import com.example.taskmanager.model.TaskStatus;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
    public List<Task> getAllTask(Task task) {
        return taskRepository.findAll();
    }

    @PostConstruct
    public void init(){
       Task task1= new Task("take out the trash ","after lunch ", TaskPriority.LOW, TaskStatus.OPEN );
      Task task2=  new Task("to wash hands","liquid soap",TaskPriority.HIGHT,TaskStatus.OPEN);

      Task task3=  new Task("buy products","in the shop",TaskPriority.NORMAL,TaskStatus.CLOSED);

    }
}
