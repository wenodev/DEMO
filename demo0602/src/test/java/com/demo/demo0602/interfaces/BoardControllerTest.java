package com.demo.demo0602.interfaces;

import com.demo.demo0602.domain.Board;
import com.demo.demo0602.domain.BoardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BoardRepository boardRepository;

    @MockBean
    private Board board;

    @Test
    public void saveBoard() throws Exception {

        Board board = Board.builder()
                .id(1L)
                .title("t1")
                .content("c1")
                .build();

        mvc.perform(post("/api/boards")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(board)))
                .andExpect(status().isOk());

        verify(boardRepository).save(any());

    }

    @Test
    public void getBoards() throws Exception {

        mvc.perform(get("/api/boards"))
                .andExpect(status().isOk());

        verify(boardRepository).findAll();
    }


    //error 발생 - service 작성하면서 변경 예정
    @Test
    public void updateBoard() throws Exception {
        Board board = Board.builder()
                .id(1L)
                .title("t1")
                .content("c1")
                .build();

        mvc.perform(patch("/api/boards")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(board)))
                .andExpect(status().isOk());

    }


    @Test
    public void delete() {


    }
}