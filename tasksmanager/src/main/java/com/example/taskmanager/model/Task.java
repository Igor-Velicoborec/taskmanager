package com.example.taskmanager.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String TaskName;

    private String description;

    @Enumerated(EnumType.STRING)
    private  TaskPriority taskPriority;

    @Enumerated(EnumType.STRING)
    private  TaskStatus taskStatus;

}
