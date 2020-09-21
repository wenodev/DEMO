package com.demo.demo0617.common.dto;

import com.demo.demo0617.common.domain.Member;
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
    public MemberDto(Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.name = member.getName();
        this.createdDate = member.getCreatedDate();
        this.modifiedDate = member.getModifiedDate();
    }

}
