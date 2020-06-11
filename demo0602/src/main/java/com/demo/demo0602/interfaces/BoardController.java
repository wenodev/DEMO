package com.demo.demo0602.interfaces;

import com.demo.demo0602.application.BoardService;
import com.demo.demo0602.application.MemberService;
import com.demo.demo0602.domain.Board;
import com.demo.demo0602.domain.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
public class BoardController {

    private BoardService boardService;


    @GetMapping("/boards")
    public String get(Model model, SessionUser sessionUser){

        List<Board> boards = boardService.get();
        model.addAttribute("boardList", boards);


        return "/user/list";
    }

    @PostMapping("/api/boards")
    public @ResponseBody Board save(@RequestBody Board board){
        return boardService.save(board);
    }

    @PatchMapping("/api/boards/{id}")
    public @ResponseBody Board update(@PathVariable Long id, @RequestBody Board board){
        return boardService.update(board, id);
    }

    @DeleteMapping("/api/boards/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }

}
