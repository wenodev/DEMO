package com.demo.demo0612.controller;

import com.demo.demo0612.entity.User;
import com.demo.demo0612.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;


    @PostMapping("/user")
    public void signUp(@RequestBody User user) {
        userService.saveUser(user);
    }


}
