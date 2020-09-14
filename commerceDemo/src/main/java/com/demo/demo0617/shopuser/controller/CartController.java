package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.domain.Cart;
import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.shopadmin.service.ProductService;
import com.demo.demo0617.shopuser.service.CartService;
import com.demo.demo0617.shopuser.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@Controller
public class CartController {

    private CartService cartService;
    private ProductService productService;
    private MemberService memberService;


    @GetMapping("/cart")
    public String cartPage(Model model, Principal principal) {

        Member member = memberService.findByEmail(principal.getName());
        List<Cart> cartList = cartService.findByMember(member);

        model.addAttribute("cartList", cartList);

        return "/customer/cart";
    }

    @PostMapping("/cart")
    public String saveCart(Long id, int quantity, Principal principal) {

        Member member = memberService.findByEmail(principal.getName());
        Product product = productService.findById(id);

        cartService.saveCart(member, product, quantity);

        return "redirect:/cart";
    }

}
