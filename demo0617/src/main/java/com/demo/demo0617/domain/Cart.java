package com.demo.demo0617.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Cart extends TimeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(length = 100)
    private int cartQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;


    @Builder
    public Cart(Long id, int cartQuantity,  Product product){
        this.id = id;
        this.cartQuantity = cartQuantity;
        this.product = product;
    }


}
