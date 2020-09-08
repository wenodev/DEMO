package com.demo.demo0617.shopuser.service;


import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.domain.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;


    //회원 아이디로 찾기
    @Test
    public void findByIdTest(){

        Member member = Member.builder()
                .email("test@test.com")
                .build();

        given(memberRepository.findByEmail("test@test.com"))
                .willReturn(java.util.Optional.ofNullable(member));
        then(memberRepository).should()
                .findByEmail(any());
    }

}