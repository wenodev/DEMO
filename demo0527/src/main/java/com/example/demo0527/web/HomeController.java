package com.example.demo0527.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/home")
    public String Hello(){
        return "home";
    }

}
