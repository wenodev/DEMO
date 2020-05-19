package com.example.demo0518.entity;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @Test
    public void boardEntityTest(){

        //given
        String title = "title1";
        String content = "content1";

        //when
        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();

        //then
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);


    }
}