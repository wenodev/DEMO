package com.demo.demo0617.common.dto;

import com.demo.demo0617.common.domain.Cart;
import com.demo.demo0617.common.domain.Product;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class CartDto {

    private Long id;
    private int cartQuantity;
    private float cartPrice;
    private Product product;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Cart toEntity(){
        return Cart.builder()
                .id(id)
                .cartQuantity(cartQuantity)
                .cartPrice(cartPrice)
                .product(product)
                .build();
    }

    @Builder
    public CartDto(Long id, int cartQuantity, float cartPrice, Product product, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id = id;
        this.cartQuantity = cartQuantity;
        this.cartPrice = cartPrice;
        this.product = product;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }



}
