package com.demo.demo0617.shopadmin.controller;

import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.config.storage.StorageService;
import com.demo.demo0617.shopadmin.service.CategoryService;
import com.demo.demo0617.shopadmin.service.ProductService;
import com.demo.demo0617.shopuser.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class AdminController {

    private ProductService productService;
    private CategoryService categoryService;
    private final StorageService storageService;
    private OrderService orderService;

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
    public String productRegister(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "/admin/product-register";
    }

    //주문 내역 페이지
    @GetMapping("/admin/order-list")
    public String adminOrderList(Model model){
        model.addAttribute("orderList", orderService.findAll());
        return "/admin/order-list";
    }

}
