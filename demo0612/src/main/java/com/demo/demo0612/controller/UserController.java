package com.demo.demo0612.controller;

import com.demo.demo0612.entity.User;
import com.demo.demo0612.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@AllArgsConstructor
@Controller
public class UserController {

    private UserService userService;

    // 메인 페이지
    @GetMapping("/")
    public String index(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!auth.getName().equals("anonymousUser")){
            User user = userService.findByEmail(auth.getName());
            model.addAttribute("User", user);
        }

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
