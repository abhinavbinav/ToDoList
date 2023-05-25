package com.abhi.springboot.todolist.todo;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller @SessionAttributes("name")
public class ToDoListControllerJPA {

    private Logger logger = LoggerFactory.getLogger(getClass());
    public ToDoListControllerJPA(ToDoListService toDoListService, ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Autowired
    private ToDoListRepository toDoListRepository;

    @RequestMapping("/todolist")
    public String getToDo(ModelMap model){
        model.put("list", toDoListRepository.findByname(getLoggedInUserName()));
        return "tdl";
    }

    @RequestMapping(value="/addtolist", method = RequestMethod.GET)
    public String addToList(ModelMap model){
        String uname = getLoggedInUserName();
        ToDoList toDoList = new ToDoList(999, uname, "", Boolean.FALSE);
        model.put("toDoList", toDoList);
        return "addtolist";
    }

    @RequestMapping(value="/addtolist", method = RequestMethod.POST)
    public String addNewToList(@Valid ToDoList toDoList, ModelMap model, BindingResult result){
        if(result.hasErrors()){
            return "redirect:todolist";
        }
        logger.debug(toDoList.toString());
        String uname = getLoggedInUserName();
        toDoList.setName(uname);
        logger.debug(toDoList.toString());
        toDoListRepository.save(toDoList);
        return "redirect:todolist";
    }

    @RequestMapping("/deletetodo")
    public String deleteToDo(@RequestParam int id){
        toDoListRepository.deleteById(id);
        return "redirect:todolist";
    }

    @RequestMapping(value="/updatelist", method = RequestMethod.GET)
    public String updateList(ModelMap model, @RequestParam int id){
        String uname = getLoggedInUserName();
        ToDoList current_todo = toDoListRepository.findByid(id);
        model.put("toDoList", current_todo);
        return "updatelist";
    }

    @RequestMapping(value="/updatelist", method = RequestMethod.POST)
    public String updateListPost(ModelMap model, @Valid ToDoList toDoList){
        String uname = (String)model.get("name");
        toDoList.setName(uname);
        toDoListRepository.save(toDoList);
        return "redirect:todolist";
    }

    private String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


}
