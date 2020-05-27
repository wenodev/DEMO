package com.example.demo0527.application;

import com.example.demo0527.domain.Board;
import com.example.demo0527.domain.BoardRepository;
import com.example.demo0527.web.dto.BoardListResponse;
import com.example.demo0527.web.dto.BoardSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Long saveBoard(BoardSaveRequestDto boardSaveRequestDto) {
        return boardRepository.save(boardSaveRequestDto.toEntity()).getId();
    }

    public List<BoardListResponse> findAllBoard(){

        List<BoardListResponse> boardListResponse = new ArrayList<>();
        boardListResponse.forEach(boardListResponse1 ->
                boardListResponse.add(boardListResponse1) );

         return boardListResponse;
    }
}
