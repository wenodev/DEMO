package com.demo.demo0602.pages;

import com.demo.demo0602.application.BoardService;
import com.demo.demo0602.domain.Board;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@AllArgsConstructor
@Controller
public class BoardPages {

    private BoardService boardService;

    @GetMapping("/boards")
    public String get(Model model){

        List<Board> boards = boardService.get();
        model.addAttribute("boardList", boards);

        return "list";
    }
}
