package com.example.demo0527.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BoardTest {

    @Test
    public void board(){
        //given
        String title = "t1";
        String content = "c1";

        //when
        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();

        //then
        assertThat(board.getTitle()).isEqualTo(title);

    }

}