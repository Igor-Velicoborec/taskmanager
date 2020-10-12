package com.example.taskmanager.entity;


import com.example.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class DbLoader implements CommandLineRunner {


    private final TaskRepository taskRepository;


    @Override
    public void run(String... args) throws Exception {

//        taskRepository.save(new Task("clean room", "",Priority.NORMAL,Status.IN_PROGRESS));
//        taskRepository.save(new Task("clean washroom", "",Priority.LOW,Status.CLOSED));
//        taskRepository.save(new Task("clean kitchen", "",Priority.HIGHT,Status.OPEN));


    }
}
