package com.demo.demo0617.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @GetMapping("/admin/category-register")
    public String showCategory(){
        return "/admin/category-register";
    }

}
