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
public ProductDto(Product product){
    this.id = product.getId();
    this.productCode = product.getProductCode();
    this.productName = product.getProductName();
    this.productPrice = product.getProductPrice();
    this.quantity = product.getQuantity();
    this.productFileImg = product.getProductFileImg();
    this.productUrlImg = product.getProductUrlImg();
    this.imgType = product.getImgType();
    this.productDescription = product.getProductDescription();
    this.category = product.getCategory();
    this.createdDate = product.getCreatedDate();
    this.modifiedDate = product.getModifiedDate();
}



}
