package com.demo.demo0617.controller.api;

import com.demo.demo0617.dto.ProductDto;
import com.demo.demo0617.service.ProductService;
import com.demo.demo0617.storage.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Controller
public class ProductApiController {

    private ProductService productService;
    private final StorageService storageService;

    //상품 등록
    @PostMapping("/admin/product-register")
    public String saveProduct(String productCode, String productName, float productPrice, int quantity, @RequestParam("file") MultipartFile file, String productUrlImg, String imgType) {

        if(!file.isEmpty()){
            storageService.store(file);
        }

        ProductDto productDto = ProductDto.builder()
                .productCode(productCode)
                .productName(productName)
                .productPrice(productPrice)
                .quantity(quantity)
                .productFileImg(file.getOriginalFilename())
                .productUrlImg(productUrlImg)
                .imgType(imgType)
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
