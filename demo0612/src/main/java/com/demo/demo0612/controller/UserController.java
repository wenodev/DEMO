package com.demo.demo0612.controller;

import com.demo.demo0612.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class UserController {

    private UserService userService;

    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "/index";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String dispLogin() {
        return "login";
    }

    // 회원가입 페이지
    @GetMapping("/signup")
    public String dispSignup() {
        return "signup";
    }

}
