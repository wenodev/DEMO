package com.example.demo0527.web.dto;

import com.example.demo0527.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardSaveRequestDto {
    private String title;
    private String content;

    @Builder
    public BoardSaveRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
