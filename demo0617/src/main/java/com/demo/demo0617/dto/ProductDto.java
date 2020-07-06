package com.demo.demo0617.dto;


import com.demo.demo0617.domain.Category;
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
    private float productPrice;
    private int quantity;
    private String productFileImg;
    private String productUrlImg;
    private String imgType;
    private Category category;

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
                .category(category)
                .build();
    }

    @Builder
    public ProductDto(Long id, String productCode, String productName, float productPrice, int quantity, String productFileImg, String productUrlImg, String imgType, Category category){
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.productFileImg = productFileImg;
        this.productUrlImg = productUrlImg;
        this.imgType = imgType;
        this.category = category;
    }



}
