package com.demo.demo0617.controller.api;

import com.demo.demo0617.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class CartApiController {

    private CartService cartService;


    @PostMapping("/cart")
    public String saveCart(Long id, String quantity){




        return "redirect:/cart";
    }

}
