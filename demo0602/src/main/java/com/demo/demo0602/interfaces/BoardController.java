package com.demo.demo0602.interfaces;

import com.demo.demo0602.application.BoardService;
import com.demo.demo0602.application.MemberService;
import com.demo.demo0602.domain.Board;
import com.demo.demo0602.domain.Member;
import com.demo.demo0602.interfaces.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class BoardController {

    private BoardService boardService;
    private MemberService memberService;

    @GetMapping("/boards/save")
    public String boardsSave(Principal principal, Model model){

        Member member = memberService.findByEmail(principal.getName()).get();
        System.out.println("principal.getName() : " + principal.getName());
        System.out.println("member email : " + member.getEmail());
        model.addAttribute("Member", member);

        return "/user/board/post-list";
    }


    @GetMapping("/boards/{id}")
    public String getById(Model model, @PathVariable Long id){

        Optional<Board> board = boardService.getById(id);
        model.addAttribute("Board", board.get());
        return "/user/list-detail";
    }

    @GetMapping("/boards")
    public String get(Model model){

        List<Board> boards = boardService.get();
        model.addAttribute("boardList", boards);

        return "/user/list";
    }

    @PostMapping("/boards")
    public @ResponseBody Board save(String title, String content, String email){

        System.out.println("get email : " + email);

        Member member = memberService.findByEmail(email).get();

        Board board = Board.builder()
                .title(title)
                .content(content)
                .member(member)
                .build();

        return boardService.save(board);
    }

    @PatchMapping("/boards/{id}")
    public @ResponseBody Board update(@PathVariable Long id, @RequestBody Board board){
        return boardService.update(board, id);
    }

    @DeleteMapping("/boards/{id}")
    public void delete(@PathVariable Long id){
        boardService.delete(id);
    }

}
