package com.demo.demo0617.shopuser.service;

import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.domain.MemberRepository;
import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.common.dto.MemberDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    //회원 가입 처리
    @Test
    public void joinUserTest(){

        //given
        Long id = 1L;
        Member member = Member.builder()
                .id(id)
                .password("pwd1")
                .build();


        MemberDto mockMemberDto = MemberDto.builder()
                .member(member)
                .build();



        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        mockMemberDto.setPassword(passwordEncoder.encode(mockMemberDto.getPassword()));;

        given(memberRepository.save(any())).willReturn(mockMemberDto.toEntity());

        //when
        Long resultId = memberService.joinUser(mockMemberDto);

        //then
        then(memberRepository).should().save(any());
        assertThat(mockMemberDto.getId(), is(resultId));
    }

    //회원 id로 찾기
    @Test
    public void findByIdTest(){
        //given
        Long id = 11L;

        Member mockMember = Member.builder()
                .id(id)
                .build();

        given(memberRepository.findById(id)).willReturn(Optional.of(mockMember));

        //when
        MemberDto memberDto = memberService.findById(id);

        //then
        then(memberRepository).should().findById(id);
        assertThat(memberDto.getId(), is(id));

    }


    //회원 email로 찾기
    @Test
    public void findByIdEmail() {

        //given
        String email = "test@tset.com";
        Member mockMember = Member.builder()
                .email(email)
                .build();

        given(memberRepository.findByEmail(email)).willReturn(Optional.of(mockMember));

        //when
        MemberDto memberDto = memberService.findByEmail(email);

        //then
        then(memberRepository).should().findByEmail(email);
        assertThat(memberDto.getEmail(), is(email));
    }

}