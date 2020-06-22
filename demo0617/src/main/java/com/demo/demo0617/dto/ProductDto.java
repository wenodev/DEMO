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
    private String productCode;
    private String productName;
    private String productPrice;
    private String quantity;

    public Product toEntity(){
        return Product.builder()
                .id(id)
                .productCode(productCode)
                .productName(productName)
                .productPrice(productPrice)
                .quantity(quantity)
                .build();
    }

    @Builder
    public ProductDto(Long id, String productCode, String productName, String productPrice, String quantity){
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }



}
