package com.example.taskmanager.controller;

import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final TaskService taskService;

    @Autowired
    public IndexController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks/all")
    public String allTasks(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        return "tasks";
    }
}
