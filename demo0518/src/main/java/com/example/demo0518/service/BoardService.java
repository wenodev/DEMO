package com.example.demo0518.service;

import com.example.demo0518.entity.Board;
import com.example.demo0518.entity.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {


    private final BoardRepository boardRepository;

    public Board save(String title, String content ) {

        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();

        return boardRepository.save(board);

    }

    public List<Board> getBoards(){
        return boardRepository.findAll();
    }
//
//    public Optional<Board> findById(Long id){
//        Optional<Board> board = boardRepository.findById(id);
//        return board;
//    }

}
