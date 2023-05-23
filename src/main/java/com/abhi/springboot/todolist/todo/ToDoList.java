package com.abhi.springboot.todolist.todo;

import jakarta.validation.constraints.Size;

public class ToDoList {
    private String name;
    @Size(min=10, message="idiot")
    private String task;
    private Boolean status;

    public ToDoList(String name, String task, Boolean status) {
        this.name = name;
        this.task = task;
        this.status = status;
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
                "name='" + name + '\'' +
                ", task='" + task + '\'' +
                ", status=" + status +
                '}';
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
