package com.demo.demo0617.common.dto;


import com.demo.demo0617.common.domain.Category;
import com.demo.demo0617.common.domain.Product;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String productCode;
    private String productName;
    private float productPrice;
    private int quantity;
    private String productFileImg;
    private String productUrlImg;
    private String imgType;
    private String productDescription;
    private Category category;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

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
                .productDescription(productDescription)
                .category(category)
                .build();
    }

    @Builder
    public ProductDto(Long id, String productCode, String productName, float productPrice, int quantity, String productFileImg, String productUrlImg, String imgType, String productDescription, Category category, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.productFileImg = productFileImg;
        this.productUrlImg = productUrlImg;
        this.imgType = imgType;
        this.productDescription = productDescription;
        this.category = category;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }



}
