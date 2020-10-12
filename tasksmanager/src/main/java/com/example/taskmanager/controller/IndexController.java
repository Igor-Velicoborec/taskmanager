package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final TaskService taskService;
    @Autowired
    public IndexController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/tasks")
    public String allTasks(Model model){
       model.addAttribute("tasks",taskService.getAllTask());
       return "tasks";
   }







}

