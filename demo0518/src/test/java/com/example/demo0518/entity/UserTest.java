package com.example.demo0518.entity;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @Test
    public void UserTest(){
        //given
        String name = "captain";
        String email = "captain@gamil.com";
        String mobileNumber = "010-9922-1122";

        //when
        User user = User.builder()
                .name(name)
                .email(email)
                .mobileNumber(mobileNumber)
                .build();

        //then
        assertThat(user.getName()).isEqualTo(name);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getMobileNumber()).isEqualTo(mobileNumber);

    }
}