package com.demo.demo0617.controller.api;

import com.demo.demo0617.domain.Product;
import com.demo.demo0617.dto.CartDto;
import com.demo.demo0617.dto.ProductDto;
import com.demo.demo0617.service.CartService;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class CartApiController {

    private CartService cartService;
    private ProductService productService;


    @PostMapping("/cart")
    public String saveCart(Long id, String quantity){

        Optional<Product> product = productService.findById(id);

        CartDto cartDto = CartDto.builder()
                .imgType(product.get().getImgType())
                .productCode(product.get().getProductCode())
                .productFileImg(product.get().getProductFileImg())
                .productName(product.get().getProductName())
                .productPrice(product.get().getProductPrice())
                .productUrlImg(product.get().getProductUrlImg())
                .quantity(quantity)
                .build();

        cartService.saveCart(cartDto);

        return "redirect:/cart";
    }

}
