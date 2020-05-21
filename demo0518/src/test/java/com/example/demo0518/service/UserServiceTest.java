package com.example.demo0518.service;

import com.example.demo0518.entity.User;
import com.example.demo0518.entity.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save(){

        //given
        String name = "name-1";
        String email = "email@gamil.com";
        String mobileNumber = "010-1122-3344";

        User user = User.builder()
                .name(name)
                .email(email)
                .mobileNumber(mobileNumber)
                .build();

        given(userRepository.findById(1L)).willReturn(Optional.of(user));
        userService.save(name, email, mobileNumber);

        //then
        verify(userRepository).save(any());
    }

}