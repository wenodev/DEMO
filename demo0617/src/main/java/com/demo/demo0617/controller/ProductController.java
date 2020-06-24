package com.demo.demo0617.controller;

import com.demo.demo0617.domain.Product;
import com.demo.demo0617.dto.ProductDto;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class ProductController {

    private ProductService productService;

    // 메인 페이지
    @GetMapping("/")
    public String index(Model model) {

        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);

        return "/index";
    }

    @GetMapping("/product/{id}")
    public String productById(Model model, @PathVariable Long id){

        Optional<Product> product = productService.findById(id);
        model.addAttribute("product", product.get());

        return "product";
    }

}
