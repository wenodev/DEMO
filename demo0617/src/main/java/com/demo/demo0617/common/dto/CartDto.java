package com.demo.demo0617.common.dto;

import com.demo.demo0617.common.domain.Cart;
import com.demo.demo0617.common.domain.Member;
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
    private String cookieId;
    private Product product;
    private Member member;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Cart toEntity(){
        return Cart.builder()
                .id(id)
                .cartQuantity(cartQuantity)
                .cartPrice(cartPrice)
                .cookieId(cookieId)
                .product(product)
                .member(member)
                .build();
    }

    @Builder
    public CartDto(Long id, int cartQuantity, float cartPrice, String cookieId, Product product, Member member,LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id = id;
        this.cartQuantity = cartQuantity;
        this.cartPrice = cartPrice;
        this.cookieId = cookieId;
        this.product = product;
        this.member = member;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }



}
