package com.demo.demo0617.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class AjaxTest {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String temp1;

    @Column
    private String temp2;


}
