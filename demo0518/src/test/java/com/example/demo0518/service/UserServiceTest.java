package com.example.demo0518.service;

import com.example.demo0518.entity.Board;
import com.example.demo0518.entity.User;
import com.example.demo0518.entity.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

        userService.save(name, email, mobileNumber);

        //then
        verify(userRepository).save(any());
    }

    @Test
    public void getUsers(){
        //given
        List<User> users = new ArrayList<>();

        String name = "name-1";
        String email = "email@gamil.com";
        String mobileNumber = "010-1122-3344";

        User mockUser = User.builder()
                .name(name)
                .email(email)
                .mobileNumber(mobileNumber)
                .build();

        users.add(mockUser);

        given(userService.getUsers()).willReturn(users);


    }


}