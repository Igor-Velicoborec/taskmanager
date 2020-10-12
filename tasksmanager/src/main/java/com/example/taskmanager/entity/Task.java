package com.example.taskmanager.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String name;

    private String description;

    public Task(String taskName, String description, Priority priority, Status status) {
        this.name = taskName;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Task() {}

}
