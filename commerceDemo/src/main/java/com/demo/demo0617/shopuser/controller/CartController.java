package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.domain.Cart;
import com.demo.demo0617.common.dto.MemberDto;
import com.demo.demo0617.common.dto.ProductDto;
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

        MemberDto memberDto = memberService.findByEmail(principal.getName());


        List<Cart> cartList = cartService.findByMember(memberDto.toEntity());

        model.addAttribute("cartList", cartList);

        return "/customer/cart";
    }

    @PostMapping("/cart")
    public String saveCart(Long productId, int productQuantity, Principal principal) {

        MemberDto memberDto = memberService.findByEmail(principal.getName());
        ProductDto productDto = productService.findById(productId);

        cartService.saveCart(memberDto.toEntity(), productDto.toEntity(), productQuantity);

        return "redirect:/cart";
    }

}
