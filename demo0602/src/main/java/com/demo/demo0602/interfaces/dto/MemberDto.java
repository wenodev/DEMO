package com.demo.demo0602.interfaces.dto;

import com.demo.demo0602.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
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

}
