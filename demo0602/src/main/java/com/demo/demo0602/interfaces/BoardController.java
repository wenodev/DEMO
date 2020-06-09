package com.demo.demo0602.interfaces;

import com.demo.demo0602.application.BoardService;
import com.demo.demo0602.domain.Board;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/api")
@RestController
public class BoardController {

    private BoardService boardService;

    @PostMapping("/boards")
    public Board save(@RequestBody Board board){
        return boardService.save(board);
    }

    @PatchMapping("/boards/{id}")
    public Board update(@PathVariable Long id, @RequestBody Board board){
        return boardService.update(board, id);
    }

    @DeleteMapping("/boards/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }

}
