package com.demo.ajaxObjectTest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ProductController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

}
