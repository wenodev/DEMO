package com.demo.demo0617.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String productCode;

    @Column(length = 100)
    private String productName;

    @Column(length = 100)
    private float productPrice;

    @Setter
    @Column(length = 100)
    private int quantity;

    @Column(length = 100)
    private String productFileImg;

    @Column(length = 100)
    private String productUrlImg;

    @Column
    private String imgType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;


    @Builder
    public Cart(Long id, String productCode, String productName, float productPrice, int quantity, String productFileImg, String productUrlImg, String imgType, Product product){
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.productFileImg = productFileImg;
        this.productUrlImg = productUrlImg;
        this.imgType = imgType;
        this.product = product;
    }


}
