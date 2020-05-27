package com.example.demo0527.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {

    @Autowired
    MockMvc mvc;

    @Test
    public void list() throws Exception {
        mvc.perform(get("/board"))
                .andExpect(status().isOk());
    }



}