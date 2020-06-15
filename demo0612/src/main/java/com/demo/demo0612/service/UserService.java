package com.demo.demo0612.service;

import com.demo.demo0612.entity.User;
import com.demo.demo0612.entity.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

}
