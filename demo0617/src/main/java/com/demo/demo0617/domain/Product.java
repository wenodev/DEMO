package com.demo.demo0617.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String productCode;

    @Column(length = 100)
    private String productName;

    @Column(length = 100)
    private String productPrice;

    @Column(length = 100)
    private String quantity;

    @Column(length = 100)
    private String productFileImg;

    @Column(length = 100)
    private String productUrlImg;

    @Column
    private String imgType;

    @Builder
    public Product(Long id, String productCode, String productName, String productPrice, String quantity, String productFileImg, String productUrlImg, String imgType){
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.productFileImg = productFileImg;
        this.productUrlImg = productUrlImg;
        this.imgType = imgType;
    }
}
