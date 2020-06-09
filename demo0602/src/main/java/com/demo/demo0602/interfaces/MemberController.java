package com.demo.demo0602.interfaces;

import com.demo.demo0602.application.MemberService;
import com.demo.demo0602.interfaces.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@AllArgsConstructor
@Controller
public class MemberController {

    private MemberService memberService;

    @GetMapping("/signup")
    public String signUp() {
        return "login";
    }

    @PostMapping("/signup")
    public String signUpProcess(MemberDto memberDto){
        memberService.joinUser(memberDto);

        return "list";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String dispLogin() {
        return "login";
    }


    @GetMapping("/denied")
    public String dispDenied() {
        return "denied";
    }


}
