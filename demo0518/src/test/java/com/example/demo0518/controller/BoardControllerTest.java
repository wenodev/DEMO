package com.example.demo0518.controller;

import com.example.demo0518.entity.Board;
import com.example.demo0518.entity.BoardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void findAll() throws Exception {
        mvc.perform(get("/list"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void addBoard() throws Exception {

        //given
        String title = "title";
        String content = "content";

        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();

        //when
        mvc.perform(post("/addBoard")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(board)))
                .andExpect(status().isOk());
    }
}