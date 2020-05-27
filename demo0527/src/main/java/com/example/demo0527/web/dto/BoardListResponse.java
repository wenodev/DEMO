package com.example.demo0527.web.dto;


import com.example.demo0527.domain.Board;
import lombok.Getter;

@Getter
public class BoardListResponse {

    private String title;
    private String content;


    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content).build();
    }



}
