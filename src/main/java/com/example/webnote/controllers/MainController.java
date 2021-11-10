package com.example.webnote.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String base(ModelMap modelMap){
        return "redirect:main";
    }
    @GetMapping("main")
    public String main(ModelMap modelMap){
        return "main";
    }
}
