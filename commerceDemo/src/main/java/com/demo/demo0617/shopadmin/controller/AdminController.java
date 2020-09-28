package com.demo.demo0617.shopadmin.controller;

import com.demo.demo0617.shopadmin.service.ProductService;
import com.demo.demo0617.shopuser.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class AdminController {

    private ProductService productService;
    private OrderService orderService;

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin(Model model) {

        int productNumber = productService.findTableNumber();
        int orderNumber = orderService.findTableNumber();

        model.addAttribute("productNumber", productNumber);
        model.addAttribute("orderNumber", orderNumber);

        return "/admin/index";
    }

    //주문 내역 페이지
    @GetMapping("/admin/order-list")
    public String adminOrderList(Model model){
        model.addAttribute("orderList", orderService.findAll());
        return "/admin/order-list";
    }

}
