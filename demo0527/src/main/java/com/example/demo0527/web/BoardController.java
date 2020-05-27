package com.example.demo0527.web;

import com.example.demo0527.application.BoardService;
import com.example.demo0527.web.dto.BoardListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board")
    public String list(Model model){

        List<BoardListResponse> boardListResponseList = boardService.findAllBoard();
        model.addAttribute("boardList", boardListResponseList);

        return "board";
    }



}
