package com.example.webnote.controllers;

import com.example.webnote.models.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotesController {
    @GetMapping("notes")
    public String notes(@AuthenticationPrincipal Object o, ModelMap modelMap) {
        System.err.println(o);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.err.println("authentication = " + authentication);
        System.err.println(authentication.getAuthorities());
        //
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            System.err.println(authority.getAuthority().equals(
                    User.Role.USER.name()
            ));
        }
        return "notes";
    }
}
