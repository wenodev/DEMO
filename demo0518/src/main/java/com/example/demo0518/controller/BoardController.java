package com.example.demo0518.controller;

import com.example.demo0518.entity.Board;
import com.example.demo0518.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;


    @PostMapping("/addBoard")
    public void AddBoard(@RequestBody Board board){
        boardService.create(board);
    }


    @GetMapping("/list")
    public List<Board> findAll(Model model){

        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);

        return boards;
    }

    @GetMapping("/list/{id}")
    public Optional<Board> findById(@PathVariable Long id){
        return boardService.findById(id);
    }

}
