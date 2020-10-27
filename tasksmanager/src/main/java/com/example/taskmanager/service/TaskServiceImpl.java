package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public Task getById(Long id) {
        log.info("IN TaskServiceImpl getById{}", id);
        return taskRepository.getOne(id);
    }

    @Override
    public void save(Task task) {
        log.info("IN TaskServiceImpl save{}", task);
        taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        log.info("IN TaskServiceImpl updateTask{}", task);
        return taskRepository.saveAndFlush(task);
    }

    @Override
    public void deleteTask(long id) {
        log.info("IN TaskServiceImpl deleteTask{}", id);
        taskRepository.deleteById(id);

    }

    @Override
    public List<Task> getAll() {
        log.info("IN TaskServiceImpl getAll{}");
        return taskRepository.findAll();
    }


}
