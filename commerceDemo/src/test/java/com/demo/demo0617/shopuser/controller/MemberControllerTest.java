package com.demo.demo0617.shopuser.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {

    @InjectMocks
    private MemberController memberController;
    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }

    @Test
    public void 회원가입페이지테스트() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(view().name("/customer/signup"));
    }





}