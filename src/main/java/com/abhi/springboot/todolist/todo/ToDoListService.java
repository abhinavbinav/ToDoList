package com.abhi.springboot.todolist.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;

@Service
public class ToDoListService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public static List<ToDoList> toDoList = new ArrayList<ToDoList>();
    static {
        toDoList.add(new ToDoList("abhi", "eat mac&cheese", Boolean.TRUE));
        toDoList.add(new ToDoList("abhi", "drink smoothie", Boolean.FALSE));
        toDoList.add(new ToDoList("alexandra", "send cute pics", Boolean.TRUE));

    }
    public List<ToDoList> getToDos(){
        return toDoList;
    }

    public void addToList(String name, String description){
        ToDoList newToDo = new ToDoList(name, description, Boolean.FALSE);
        toDoList.add(newToDo);
    }

    public void deleteFromList(String task){
        Predicate<? super ToDoList> predicate = t -> t.getTask().equals(task);
        toDoList.removeIf(predicate);
    }

    public ToDoList findbyTask(String task){
        Predicate<? super ToDoList> predicate = t -> t.getTask().equals(task);
        ToDoList toDo = toDoList.stream().filter(predicate).findFirst().get();
        logger.debug(toDo.toString());
        return toDo;
    }
}
