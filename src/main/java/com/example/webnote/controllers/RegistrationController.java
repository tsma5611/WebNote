package com.example.webnote.controllers;

import com.example.webnote.models.User;
import com.example.webnote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

import static com.example.webnote.models.User.Role.USER;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("registration")
    public String registration( ModelMap modelMap) {
        return "registration";
    }

    //spring reg
    @PostMapping("register")
    public String register(

                           @RequestParam String login,
                           @RequestParam String pass,
                           @RequestParam String nickName,
                           @RequestParam String mail,
                           ModelMap modelMap) {

        //
        User user = new User(0, login, pass, nickName, mail,
                User.Status.ACTIVE, Collections.singleton(USER), null);
        //
        System.err.println("register " + userService.findByLogin(login));
        if (userService.findByLogin(login) == null) {
            System.err.println(userService.save(user));
            // return new ModelAndView("redirect:");
        }
        modelMap.put("user", user);
        //return new ModelAndView("redirect:registration", modelMap);
        return "redirect:main";
    }
}
