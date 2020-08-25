package com.demo.demo0617.shopuser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SampleSessionRestController {

    @GetMapping("/session")
    String uid(HttpSession session){
        return session.getId();
    }

}
