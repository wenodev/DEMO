package com.demo.demo0617.controller;

import com.demo.demo0617.domain.Product;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class OrderController {

    private ProductService productService;

    @GetMapping("/order/{id}")
    public String orderById(Long productId, String quantity, Model model){

        System.out.println("productId : " + productId);
        System.out.println("quantity : " + quantity);

        Optional<Product> productDto = productService.findById(productId);
        productDto.get().setQuantity(quantity);

        model.addAttribute("product", productDto.get());

        return "order";
    }





}
