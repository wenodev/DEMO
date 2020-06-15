package com.demo.demo0612.entity;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {

    @Test
    public void firstTest(){
        User user = User.builder()
                .email("email-1")
                .password("pwd-1")
                .name("name-1")
                .build();

        assertThat(user.getEmail()).isEqualTo("email-1");
    }
}