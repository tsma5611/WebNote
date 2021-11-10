package com.example.webnote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller
public class AuthorizationController {
    @GetMapping("authorization")
    public String authorization(Model model){
        return "authorization";
    }

//    @PostMapping("authorize")
//    public String authorize(ModelMap modelMap){
//        System.err.println("authorize");
//        return "authorization";
//    }
}
