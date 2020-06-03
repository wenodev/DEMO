package com.demo.demo0602.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 64)
    private String title;

    @Column(length = 1024)
    private String content;

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }


}
