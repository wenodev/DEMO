package com.demo.demo0617.common.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Product extends TimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productCode;

    @Column
    private String productName;

    @Column
    private float productPrice;

    @Column
    private int quantity;

    @Column
    private String productFileImg;

    @Column
    private String productUrlImg;

    @Column
    private String imgType;

    @Column
    private String productDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    @Builder
    public Product(Long id, String productCode, String productName, float productPrice, int quantity, String productFileImg,
                   String productUrlImg, String imgType, String productDescription, Category category){
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.productFileImg = productFileImg;
        this.productUrlImg = productUrlImg;
        this.imgType = imgType;
        this.productDescription = productDescription;
        this.category = category;
    }
}
