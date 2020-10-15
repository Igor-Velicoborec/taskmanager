package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Priority;
import com.example.taskmanager.entity.Status;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private final TaskService taskService;
    @Autowired
    public IndexController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/tasks/all")
    public String allTasks(Model model){
       model.addAttribute("tasks",taskService.getAllTask());
       return "tasks";
   }

   @RequestMapping("/register")
    public String registerTask(@RequestParam  String name,
                               @RequestParam (required = false) String description,
                               @RequestParam (required = false) Priority priority,
                               @RequestParam Status status, Model model){
        try {


        Task task = new Task(name,description, priority,status);
        taskService.createTask(task);
        model.addAttribute("task", task);
        return "registration-success";
        } catch (Exception e){
            String message="the entered data is not correct";
            System.out.println(message+" "+e);
        }

       return "registration-failed";
   }







}

