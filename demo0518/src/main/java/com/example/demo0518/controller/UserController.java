package com.example.demo0518.controller;

import com.example.demo0518.entity.Board;
import com.example.demo0518.entity.User;
import com.example.demo0518.service.BoardService;
import com.example.demo0518.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody User resource) throws URISyntaxException {
        String name = resource.getName();
        String email = resource.getEmail();
        String mobile = resource.getMobileNumber();

        User user = userService.save(name, email, mobile);

        String url = "/user/add" + user.getId();

        return ResponseEntity.created(new URI(url)).body(user);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getUsers(){

        List<User> users = userService.getUsers();

        return null;
    }





}
