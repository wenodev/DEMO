package com.demo.demo0617.dto;

import com.demo.demo0617.domain.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public Member toEntity(){
        return Member.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String name, LocalDateTime createdDate, LocalDateTime modifiedDate ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
