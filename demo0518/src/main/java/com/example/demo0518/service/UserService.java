package com.example.demo0518.service;

import com.example.demo0518.entity.User;
import com.example.demo0518.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(String name, String email, String mobileNumber) {

        User user = User.builder()
                .name(name)
                .email(email)
                .mobileNumber(mobileNumber)
                .build();

        return userRepository.save(user);
    }
}
