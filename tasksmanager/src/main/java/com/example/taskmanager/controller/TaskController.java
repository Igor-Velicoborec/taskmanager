package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.model.TaskPriority;
import com.example.taskmanager.model.TaskStatus;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {
    private final TaskRepository taskRepository;
    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping("/task")
    public String task(@RequestParam(name = "name", required = false, defaultValue = "User") String name, Model model) {
        model.addAttribute("name", name);
        return "task";
    }
    @PostMapping
    public String add(@RequestParam String taskName, @RequestParam String description,
                      @RequestParam TaskPriority taskPriority, @RequestParam TaskStatus taskStatus,
                      Model model){
        Task task=new Task(taskName,description,taskPriority,taskStatus);
        taskRepository.save(task);


        return "task";
    }

}

