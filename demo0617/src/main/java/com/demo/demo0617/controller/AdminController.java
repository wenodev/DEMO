package com.demo.demo0617.controller;

import com.demo.demo0617.domain.Product;
import com.demo.demo0617.dto.MemberDto;
import com.demo.demo0617.dto.ProductDto;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class AdminController {

    private ProductService productService;

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin/index";
    }

    // 상품 리스트 페이지
    @GetMapping("/admin/product-list")
    public String productList(Model model) {

        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);

        return "/admin/product-list";
    }

    // 상품 등록 페이지
    @GetMapping("/admin/product-register")
    public String productRegister() {
        return "/admin/product-register";
    }


    //상품 등록
    @PostMapping("/admin/product-register")
    public String saveProduct(ProductDto productDto){
        productService.saveProduct(productDto);
        return "redirect:/admin/product-list";
    }




}
