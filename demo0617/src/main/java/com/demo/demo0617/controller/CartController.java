package com.demo.demo0617.controller;

import com.demo.demo0617.domain.Cart;
import com.demo.demo0617.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class CartController {

    private CartService cartService;

    @GetMapping("/cart")
    public String cartPage(Model model){

        List<Cart> cartList = cartService.findAll();
        model.addAttribute("cartList", cartList);

        return "cart";
    }







}
