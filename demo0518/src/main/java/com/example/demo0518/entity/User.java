package com.example.demo0518.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String mobileNumber;

    @Builder
    public User(String name, String email, String mobileNumber){
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }




}
