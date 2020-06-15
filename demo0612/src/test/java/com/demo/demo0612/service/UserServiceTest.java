package com.demo.demo0612.service;

import com.demo.demo0612.entity.User;
import com.demo.demo0612.entity.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;


public class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveUser() {
        User user = User.builder()
                .email("email-1")
                .password("pwd-1")
                .name("name-1")
                .build();

        userService.saveUser(user);

        verify(userRepository).save(any());


    }


}