package com.demo.demo0612.pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserPages {

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String mypage(Principal principal, Model model){
        String userEmail = principal.getName();

        model.addAttribute("userEmail", userEmail);



        return "mypage";
    }

}
