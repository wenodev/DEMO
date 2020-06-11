package com.demo.demo0602.interfaces.dto;

import com.demo.demo0602.domain.Member;
import lombok.*;


@Builder
@AllArgsConstructor
@Getter
public class MemberDto {

    private Long id;
    private String email;

    @Setter
    private String password;

    public Member toEntity(){
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .build();
    }

}
