package com.demo.demo0617.common.dto;

import com.demo.demo0617.common.domain.Address;
import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.domain.Orders;
import com.demo.demo0617.common.domain.Product;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrdersDto {


    private Long id;
    private String orderNumber;
    private int quantity;
    private float totalPrice;
    private Member member;
    private Product product;
    private Address address;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Orders toEntity(){
        return Orders.builder()
                .id(id)
                .orderNumber(orderNumber)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .member(member)
                .product(product)
                .address(address)
                .build();
    }

    //기본 생성자
    @Builder
    public OrdersDto(Orders orders){
        this.id = orders.getId();
        this.orderNumber = orders.getOrderNumber();
        this.quantity = orders.getQuantity();
        this.totalPrice = orders.getTotalPrice();
        this.member = orders.getMember();
        this.product = orders.getProduct();
        this.address = orders.getAddress();
        this.createdDate = orders.getCreatedDate();
        this.modifiedDate = orders.getModifiedDate();
    }



}
