package com.abhi.springboot.todolist.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String u, String p){
        return u.equalsIgnoreCase("abhi") && p.equalsIgnoreCase("password");
    }
}
