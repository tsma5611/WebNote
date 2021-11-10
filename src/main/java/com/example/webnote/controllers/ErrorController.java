package com.example.webnote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    //параметр
    @GetMapping("/error")
    public String error(Model model) {
        System.err.println("ERROR");
        return "redirect:/main";
    }
}
//присутствие активность кнопки
