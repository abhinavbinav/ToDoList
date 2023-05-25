package com.abhi.springboot.todolist.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<ToDoList, Integer> {
    public List<ToDoList> findByname(String name);
    public ToDoList findByid(int id);
}
