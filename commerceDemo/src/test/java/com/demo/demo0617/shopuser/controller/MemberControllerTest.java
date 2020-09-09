package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.dto.MemberDto;
import com.demo.demo0617.shopuser.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {

    @InjectMocks
    private MemberController memberController;

    @Mock
    private MemberService memberService;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
    }

    //회원 가입 페이지
    @Test
    public void dispSignupTest() throws Exception {
        mockMvc.perform(get("/signup"))
                .andExpect(view().name("/customer/signup"))
                .andExpect(status().isOk());
    }

    //회원 가입 처리
    @Test
    public void signUpTest() throws Exception {

        //given
        MemberDto memberDto = MemberDto.builder()
                .id(11L)
                .email("test@email.com")
                .build();

        //when
        ObjectMapper objectMapper = new ObjectMapper();
        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(memberDto)))
                .andExpect(status().isOk());

        //then
        verify(memberService).joinUser(any(MemberDto.class));
    }

    //로그인 페이지
    @Test
    public void login() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(view().name("/customer/login"))
                .andExpect(status().isOk());
    }



}


