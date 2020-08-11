package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.dto.MemberDto;
import com.demo.demo0617.shopuser.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(MemberController.class)
@Slf4j
public class MemberControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private MemberService memberService;

    @Test
    void signUp() throws Exception{

        //given
        MemberDto memberDto = MemberDto.builder()
                .name("name1")
                .email("email")
                .build();
    }

}