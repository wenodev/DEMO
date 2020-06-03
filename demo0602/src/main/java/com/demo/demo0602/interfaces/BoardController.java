package com.demo.demo0602.interfaces;

import com.demo.demo0602.domain.Board;
import com.demo.demo0602.domain.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class BoardController {

    private BoardRepository boardRepository;

    @PostMapping("/boards")
    public Board save(Board board){
        System.out.println(board.getTitle());
        return boardRepository.save(board);
    }

    @GetMapping("/boards")
    public List<Board> get(){
        List<Board> boards = new ArrayList<>();
        boards = boardRepository.findAll();
        return boards;
    }

    @PatchMapping("/boards")
    public void update(@RequestBody Board resource){

        Long boardId = resource.getId();
        String title = resource.getTitle();
        String content = resource.getContent();

        Board board = boardRepository.findById(boardId).orElse(null);
        board.update(title, content);

    }

    @DeleteMapping("/boards")
    public void delete(@RequestBody Board resource){
        Long boardId = resource.getId();
        boardRepository.deleteById(boardId);
    }

}
