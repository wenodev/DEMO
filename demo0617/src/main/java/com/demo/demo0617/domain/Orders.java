package com.demo.demo0617.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String orderNumber;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "address_id")
//    private Address address;
//
//    @Builder
//    public Order(Long id, String orderNumber, Product product, Address address){
//        this.id = id;
//        this.orderNumber = "product" + makeRandom();
//        this.product = product;
//        this.address = address;
//    }

    private int makeRandom(){
        return (int)(Math.random()*1000000000) % 10000;
    }



}
