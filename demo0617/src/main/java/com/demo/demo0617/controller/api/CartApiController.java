package com.demo.demo0617.controller.api;

import com.demo.demo0617.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class CartApiController {

    private CartService cartService;

    @PostMapping("/cart")
    public String saveCart(Long id, String quantity){

        System.out.println("id :" + id);
        System.out.println("quantity : " + quantity);


        System.out.println("called saveCart Controller");
        return "redirect:/cart";
    }

}
