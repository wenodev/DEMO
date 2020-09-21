package com.demo.demo0617.shopadmin.controller;

import com.demo.demo0617.common.domain.Category;
import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.common.dto.CategoryDto;
import com.demo.demo0617.common.dto.ProductDto;
import com.demo.demo0617.config.storage.StorageService;
import com.demo.demo0617.shopadmin.service.CategoryService;
import com.demo.demo0617.shopadmin.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Controller
public class ProductAdminController {

    private ProductService productService;
    private CategoryService categoryService;
    private final StorageService storageService;

    //상품 등록
    @PostMapping("/admin/product-register")
    public String saveProduct(Long categoryId, String productCode, String productName, float productPrice, int quantity, @RequestParam("file") MultipartFile file, String productUrlImg, String imgType) {

        if(!file.isEmpty()){
            storageService.store(file);
        }

        Category category = categoryService.findById(categoryId);

        Product product = Product.builder()
                .category(category)
                .productCode(productCode)
                .productName(productName)
                .productPrice(productPrice)
                .quantity(quantity)
                .productFileImg(file.getOriginalFilename())
                .productUrlImg(productUrlImg)
                .imgType(imgType)
                .build();

        ProductDto productDto = ProductDto.builder()
                .product(product)
                .build();


        if(imgType.equals("url")){
            productDto.setProductFileImg(null);
        }else{
            productDto.setProductUrlImg(null);
        }
        productService.saveProduct(productDto);
        return "redirect:/admin/product-list";
    }


}
