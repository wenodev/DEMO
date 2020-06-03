package com.demo.demo0602.application;

import com.demo.demo0602.domain.Board;
import com.demo.demo0602.domain.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class BoardServiceTest {

    @Mock
    BoardRepository boardRepository;

    @InjectMocks
    BoardService boardService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {

        String title = "t1";
        String content = "c1";

        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();

        boardService.save(board);
        verify(boardRepository).save(any());
    }

    @Test
    public void get() {
        boardService.get();
        verify(boardRepository).findAll();
    }

    @Test
    public void update() {

        Board board1 = Board.builder()
                .id(1L)
                .title("t1")
                .content("c1")
                .build();

        Board board2 = Board.builder()
                .id(1L)
                .title("t2")
                .content("c2")
                .build();

        given(boardRepository.findById(board1.getId())).willReturn(Optional.of(board1));

        boardService.update(board2, 1L);

        assertThat(board2.getTitle()).isEqualTo("t2");
    }

    @Test
    public void delete() {
        boardService.delete(any());
        verify(boardRepository).deleteById(any());
    }

}