package com.example.demo0527.web.api;

import com.example.demo0527.application.BoardService;
import com.example.demo0527.web.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class BoardApiController {


    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<?> saveBoard(BoardSaveRequestDto boardSaveRequestDto) throws URISyntaxException {

        Long boardId = boardService.saveBoard(boardSaveRequestDto);

        URI location = new URI("/board/" + boardId);
        return ResponseEntity.created(location).body("{}");
    }




}
