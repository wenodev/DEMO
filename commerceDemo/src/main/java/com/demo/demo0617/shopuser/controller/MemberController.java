package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.dto.MemberDto;
import com.demo.demo0617.shopuser.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    // 회원가입 페이지
    @GetMapping("/signup")
    public String dispSignup() {
        return "/customer/signup";
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public @ResponseBody MemberDto execSignup(@RequestBody MemberDto memberDto) {

        System.out.println("execSignup Controller");
        System.out.println(memberDto.getEmail());

        memberService.joinUser(memberDto);
        return memberDto;
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String dispLogin(HttpServletRequest request) {
        return "/customer/login";
    }

    // 로그인 결과 페이지
    @GetMapping("/login/result")
    public String dispLoginResult() {
        return "/customer/loginSuccess";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/logout/result")
    public String dispLogout() {
        return "/customer/logout";
    }

    // 접근 거부 페이지
    @GetMapping("/denied")
    public String dispDenied() {
        return "/customer/denied";
    }

    // 내 정보 페이지
    @GetMapping("/info")
    public String dispMyInfo() {
        return "/customer/myinfo";
    }

}
