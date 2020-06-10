package com.demo.demo0602.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    MEMBER_LEVEL_1("LEVEL1"),
    MEMBER_LEVEL_2("LEVEL2");

    private String value;


}
