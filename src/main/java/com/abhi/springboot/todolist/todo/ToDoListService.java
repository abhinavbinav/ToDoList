package com.abhi.springboot.todolist.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;

@Service
public class ToDoListService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private int id_count = 3;

    public static List<ToDoList> toDoList = new ArrayList<ToDoList>();
    static {
        toDoList.add(new ToDoList(0, "abhi", "eat mac&cheese", Boolean.TRUE));
        toDoList.add(new ToDoList(1, "abhi", "drink smoothie", Boolean.FALSE));
        toDoList.add(new ToDoList(2, "alexandra", "send cute pics", Boolean.TRUE));

    }
    public List<ToDoList> getToDos(String username){
        Predicate<? super ToDoList> predicate = t -> t.getName().equalsIgnoreCase(username);
        return toDoList.stream().filter(predicate).toList();
    }

    public void addToList(String name, String task){
        ToDoList newToDo = new ToDoList(id_count++, name, task, Boolean.FALSE);
        toDoList.add(newToDo);
    }

    public void updateList(int id, String name, String task, Boolean status){
        ToDoList newToDo = new ToDoList(id, name, task, status);
        toDoList.add(newToDo);
    }

    public void deleteFromList(int id){
        Predicate<? super ToDoList> predicate = t -> t.getId() == id;
        toDoList.removeIf(predicate);
    }

    public ToDoList findbyID(int id){
        Predicate<? super ToDoList> predicate = t -> t.getId() == id;
        ToDoList toDo = toDoList.stream().filter(predicate).findFirst().get();
        logger.debug(toDo.toString());
        return toDo;
    }
}
