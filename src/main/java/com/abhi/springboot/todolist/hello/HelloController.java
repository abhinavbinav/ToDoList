package com.abhi.springboot.todolist.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/say-hello")
    public String sayHello(){
        return "sayHello";
    }
}
