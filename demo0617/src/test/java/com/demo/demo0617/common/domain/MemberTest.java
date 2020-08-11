package com.demo.demo0617.common.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MemberTest {

    @Test
    public void create(){
        Member member = Member.builder().name("name1").build();
        assertThat(member.getName(), is("name1"));
    }


}