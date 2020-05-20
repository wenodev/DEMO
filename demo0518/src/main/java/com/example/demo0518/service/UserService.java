package com.example.demo0518.service;

import com.example.demo0518.entity.User;
import com.example.demo0518.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User save(String name, String email, String mobileNumber) {


        return null;
    }
}
