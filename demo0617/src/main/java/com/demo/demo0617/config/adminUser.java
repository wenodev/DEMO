package com.demo.demo0617.config;

import com.demo.demo0617.dto.MemberDto;
import com.demo.demo0617.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class adminUser implements CommandLineRunner {

    private MemberService memberService;

    @Override
    public void run(String... args) throws Exception {

        MemberDto memberDto = MemberDto.builder()
                .email("admin@example.com")
                .password("1234")
                .name("admin")
                .build();

        memberService.joinUser(memberDto);

    }
}
