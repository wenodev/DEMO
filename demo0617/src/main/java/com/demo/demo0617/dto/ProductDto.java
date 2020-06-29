package com.demo.demo0617.dto;


import com.demo.demo0617.domain.Product;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String productCode;
    private String productName;
    private String productPrice;
    private String quantity;
    private String productFileImg;
    private String productUrlImg;
    private String imgType;

    public Product toEntity(){
        return Product.builder()
                .id(id)
                .productCode(productCode)
                .productName(productName)
                .productPrice(productPrice)
                .quantity(quantity)
                .productFileImg(productFileImg)
                .productUrlImg(productUrlImg)
                .imgType(imgType)
                .build();
    }

    @Builder
    public ProductDto(Long id, String productCode, String productName, String productPrice, String quantity, String productFileImg, String productUrlImg, String imgType){
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.productFileImg = productFileImg;
        this.productUrlImg = productUrlImg;
        this.imgType = imgType;
    }



}
