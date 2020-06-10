package com.demo.demo0602.interfaces;

import com.demo.demo0602.application.BoardService;
import com.demo.demo0602.domain.Board;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class BoardController {

    private BoardService boardService;

    @GetMapping("/boards")
    public String get(Model model){

        List<Board> boards = boardService.get();
        model.addAttribute("boardList", boards);

        return "list";
    }

    @PostMapping("/api/boards")
    public Board save(@RequestBody Board board){
        return boardService.save(board);
    }

    @PatchMapping("/api/boards/{id}")
    public Board update(@PathVariable Long id, @RequestBody Board board){
        return boardService.update(board, id);
    }

    @DeleteMapping("/api/boards/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }

}
