package com.demo.demo0602.interfaces;

import com.demo.demo0602.domain.Board;
import com.demo.demo0602.domain.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/board")
@RestController
public class BoardController {

    private BoardRepository boardRepository;

    @PostMapping("/save")
    public void saveBoard(Board board){
        boardRepository.save(board);
    }


}
