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

    @Column
    private int quantity;

    @Column
    private float totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @Builder
    public Orders(Long id, String orderNumber, int quantity, float totalPrice, Product product, Address address, Member member){
        this.id = id;
        this.orderNumber = "product" + makeRandom();
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
        this.address = address;
        this.member = member;
    }

    private static int makeRandom(){
        return (int)(Math.random()*1000000000) % 10000;
    }

}
