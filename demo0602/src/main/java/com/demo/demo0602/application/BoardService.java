package com.demo.demo0602.application;

import com.demo.demo0602.domain.Board;
import com.demo.demo0602.domain.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BoardService {

    private BoardRepository boardRepository;

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> get(){
        return boardRepository.findAll();
    }

    public Board update(Board resources, Long id){

        Long boardId = id;
        String title = resources.getTitle();
        String content = resources.getContent();

        Board board = boardRepository.findById(id).orElse(null);
        board.update(title, content);

        return boardRepository.save(board);
    }

    public void delete(Long id){
        boardRepository.deleteById(id);
    }

}
