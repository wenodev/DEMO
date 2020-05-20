package com.example.demo0518.controller;

import com.example.demo0518.entity.Board;
import com.example.demo0518.entity.BoardRepository;
import com.example.demo0518.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @MockBean
    private BoardService boardService;

    @Before
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }


    @Test
    public void findAll() throws Exception {

        String url = "http://localhost:" + port + "/board/list";

        mvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    public void addBoard() throws Exception {

        //given
        String title = "title";
        String content = "content";

        Board mockBoard = Board.builder()
                .title(title)
                .content(content)
                .build();

        given(boardService.save("title","content"))
                .willReturn(mockBoard);

        String url = "http://localhost:" + port + "/board/add";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"title\":\"title\"," +
                        "\"content\":\"content\"}"))
                .andExpect(status().isCreated());

        //then
        verify(boardService).save("title","content");
    }
}