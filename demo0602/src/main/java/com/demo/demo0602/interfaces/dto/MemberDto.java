package com.demo.demo0602.interfaces.dto;

import com.demo.demo0602.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberDto {

    private Long id;
    private String email;
    private String password;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

}
