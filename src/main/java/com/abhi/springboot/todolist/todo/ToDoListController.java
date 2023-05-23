package com.abhi.springboot.todolist.todo;

import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller @SessionAttributes("name")
public class ToDoListController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @Autowired
    private ToDoListService toDoListService;

    @RequestMapping("/todolist")
    public String getToDo(ModelMap model){
        model.put("list", toDoListService.getToDos());
        return "tdl";
    }

    @RequestMapping(value="/addtolist", method = RequestMethod.GET)
    public String addToList(ModelMap model){
        String uname = (String)model.get("name");
        ToDoList toDoList = new ToDoList(uname, "", Boolean.FALSE);
        model.put("toDoList", toDoList);
        return "addtolist";
    }

    @RequestMapping(value="/addtolist", method = RequestMethod.POST)
    public String addNewToList(@Valid ToDoList toDoList, ModelMap model, BindingResult result){
        if(result.hasErrors()){
            return "redirect:todolist";
        }
        String uname = (String)model.get("name");
        toDoListService.addToList(uname, toDoList.getTask());
        return "redirect:todolist";
    }

    @RequestMapping("/deletetodo")
    public String deleteToDo(@RequestParam String task){
        toDoListService.deleteFromList(task);
        return "redirect:todolist";
    }

    @RequestMapping(value="/updatelist", method = RequestMethod.GET)
    public String updateList(ModelMap model, @RequestParam String task){
        logger.debug("Task + " + task);
        ToDoList t = toDoListService.findbyTask(task);
        model.put("toDoList", t);
        return "updatelist";
    }

    @RequestMapping(value="/updatelist", method = RequestMethod.POST)
    public String updateListPost(ModelMap model, @Valid ToDoList toDoList){
        logger.debug(toDoList.getTask());
        return "redirect:todolist";
    }


}
