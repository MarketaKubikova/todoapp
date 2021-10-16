package com.example.todoapp.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short id;
    @Column (name = "name")
    private String name;
    @Column (name = "date")
    private LocalDate date;

    public Task(Short id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Task(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public Task() {

    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
