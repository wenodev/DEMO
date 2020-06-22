package com.demo.demo0617.dto;


import com.demo.demo0617.domain.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String code;
    private String name;
    private Double price;
    private Integer quantity;

    public Product toEntity(){
        return Product.builder()
                .id(id)
                .code(code)
                .name(name)
                .price(price)
                .quantity(quantity)
                .build();
    }

    @Builder
    public ProductDto(Long id, String code, String name, Double price, Integer quantity){
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }



}
