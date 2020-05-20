package com.example.demo0518.controller;

import com.example.demo0518.entity.User;
import com.example.demo0518.entity.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Autowired
    UserRepository userRepository;


    @Before
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @After
    public void cleanup(){
        userRepository.deleteAll();
    }



    @Test
    public void createUser() throws Exception {

        //given
        String name = "juwon";
        String email = "dsf@sdf.com";
        String mobileNumber = "010-2222-3333";


        User mockUser = User.builder()
                .name(name)
                .email(email)
                .mobileNumber(mobileNumber)
                .build();

        userRepository.save(mockUser);


        String url = "http://localhost" + port + "/user/add";

        //when
        mvc.perform(post(url)
            .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"name\" : \"juwon\", \"email\" : \"dsf@sdf.com\", \"mobileNumber\" : \"010-2222-3333\"}"))
            .andExpect(status().isOk());

        //then
        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getName()).isEqualTo(mockUser.getName());

    }



}