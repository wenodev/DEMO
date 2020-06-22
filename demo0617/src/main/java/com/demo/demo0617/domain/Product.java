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

    @Column(length = 100, nullable = false)
    private String productCode;

    @Column(length = 100, nullable = false)
    private String productName;

    @Column(length = 100, nullable = false)
    private String productPrice;

    @Column(length = 100, nullable = false)
    private String quantity;

    @Builder
    public Product(Long id, String productCode, String productName, String productPrice, String quantity){
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }


}
