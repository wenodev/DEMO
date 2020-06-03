package com.demo.demo0602.domain;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class BoardTest {

    @Mock
    BoardRepository boardRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void initBoard(){

        Long id = 1L;
        String title = "t1";
        String content = "c1";

        Board board = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();

        assertThat(board.getId()).isEqualTo(id);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);

    }

    @Test
    public void saveAndGetBoards(){

        Long id = 1L;
        String title = "t1";
        String content = "c1";

        Board board = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();

        List<Board> boards= new ArrayList<>();
        boards.add(board);

        given(boardRepository.findAll()).willReturn(boards);
        assertThat(boardRepository.findAll().get(0).getTitle()).isEqualTo(title);
    }


    @Test
    public void getBoardById(){

        Long id = 1L;
        String title = "t1";
        String content = "c1";

        Board board = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();

        List<Board> boards= new ArrayList<>();
        boards.add(board);

        given(boardRepository.findById(1L)).willReturn(Optional.of(board));
        assertThat(boardRepository.findById(1L).get().getTitle()).isEqualTo(title);
    }



    @Test
    public void updateBoard(){

        Long id = 1L;
        String title = "t1";
        String content = "c1";

        Board board = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .build();

        given(boardRepository.findById(1L)).willReturn(Optional.of(board));
        assertThat(boardRepository.findById(1L).get().getTitle()).isEqualTo(title);

        board.update("t2", "c2");
        assertThat(boardRepository.findById(1L).get().getTitle()).isEqualTo("t2");

    }







}