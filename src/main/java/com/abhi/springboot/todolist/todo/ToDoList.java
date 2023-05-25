package com.abhi.springboot.todolist.todo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class ToDoList {

    public ToDoList(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String task;
    private Boolean status;

    public ToDoList(int id, String name, String task, Boolean status) {
        super();
        this.name = name;
        this.task = task;
        this.status = status;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", task='" + task + '\'' +
                ", status=" + status +
                '}';
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
