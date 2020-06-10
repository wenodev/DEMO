package com.demo.demo0602.interfaces;

import com.demo.demo0602.application.MemberService;
import com.demo.demo0602.interfaces.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class MemberController {

    private MemberService memberService;

    // 사용자 마이페이지
    @GetMapping("/user/info")
    public String myInfo() {
        return "/user/myinfo";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/user/login";
    }

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup() {
        return "/user/signup";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);

        return "redirect:/user/login";
    }

}
