package com.example.demo0518.controller;

import com.example.demo0518.entity.Board;
import com.example.demo0518.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RequestMapping("/board")
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody Board resource) throws URISyntaxException {

        String title = resource.getTitle();
        String content = resource.getContent();

        Board board = boardService.save(title, content);

        String url = "/board/add" + board.getId();
        return ResponseEntity.created(new URI(url)).body("{}");
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
