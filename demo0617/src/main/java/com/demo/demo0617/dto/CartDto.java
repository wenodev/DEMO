package com.demo.demo0617.dto;

import com.demo.demo0617.domain.Cart;
import com.demo.demo0617.domain.Product;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class CartDto {

    private Long id;
    private int cartQuantity;
    private Product product;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Cart toEntity(){
        return Cart.builder()
                .id(id)
                .cartQuantity(cartQuantity)
                .product(product)
                .build();
    }

    @Builder
    public CartDto(Long id, int cartQuantity, Product product, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id = id;
        this.cartQuantity = cartQuantity;
        this.product = product;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }



}
