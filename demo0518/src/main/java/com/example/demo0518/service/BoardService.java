package com.example.demo0518.service;

import com.example.demo0518.entity.Board;
import com.example.demo0518.entity.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void create(Board board) {
        boardRepository.save(board);
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    public Optional<Board> findById(Long id){
        Optional<Board> board = boardRepository.findById(id);
        return board;

    }

}
