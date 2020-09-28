package com.demo.demo0617.common.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String productUrlImg;

    @Column
    private String productDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    @Builder
    public Product(Long id, String productCode, String productName, float productPrice, int quantity,
                   String productUrlImg, String productDescription, Category category){
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.productUrlImg = productUrlImg;
        this.productDescription = productDescription;
        this.category = category;
    }
}
