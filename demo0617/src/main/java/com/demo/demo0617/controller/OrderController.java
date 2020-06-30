package com.demo.demo0617.controller;

import com.demo.demo0617.domain.Product;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@AllArgsConstructor
@Controller
public class OrderController {

    private ProductService productService;

    @PostMapping("/order/{id}")
    public String orderById(Model model, @PathVariable Long id, String quantity ){

        System.out.println("productId : " + id);
        System.out.println("quantity : " + quantity);

        Optional<Product> productDto = productService.findById(id);
        productDto.get().setQuantity(quantity);

        model.addAttribute("product", productDto.get());

        return "order";
    }

//    @GetMapping("/product/{id}")
//    public String productById(Model model, @PathVariable Long id){
//
//        Optional<Product> product = productService.findById(id);
//        model.addAttribute("product", product.get());
//
//        return "product";
//    }

}

