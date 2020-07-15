package com.demo.demo0617.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AjaxTestController {

    @GetMapping("/ajax")
    public String ajaxTest(){

        return "common/ajax-test";

    }

}
