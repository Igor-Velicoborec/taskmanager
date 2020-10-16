package com.example.taskmanager.controller;


import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks/")
public class TaskRestControllerV1 {

    private final TaskService taskService;

    @Autowired
    public TaskRestControllerV1(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Task> getTask(@PathVariable("id") Long taskId) {
        if (taskId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Task task = taskService.getById(taskId);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Task> saveTask(@RequestBody @Validated Task task) {
        HttpHeaders headers = new HttpHeaders();
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.taskService.save(task);
        return new ResponseEntity<>(task, headers, HttpStatus.CREATED);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Task> updateTask(@RequestBody @Validated Task task, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.taskService.save(task);
        return new ResponseEntity<>(task, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Task> deleteTask(@PathVariable ("id") Long id) {
        Task task = taskService.getById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> tasks = taskService.getAll();

        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);


    }
}


