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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@Controller
public class CartController {

    private CartService cartService;
    private ProductService productService;
    private MemberService memberService;


    @GetMapping("/cart")
    public String cartPage(Model model, HttpServletRequest request) {

        List<Cart> cartList = cartService.findAll();
        model.addAttribute("cartList", cartList);

        Cookie[] cookie = request.getCookies();







        return "/customer/cart";
    }

    @PostMapping("/cart")
    public String saveCart(Long id, int quantity, Principal principal, HttpServletResponse response) {

        //쿠키 설정
        Cookie cookie = new Cookie("noneUser", "noneUser");

        cookie.setMaxAge(60);

        response.addCookie(cookie);

        //회원 비회원 구분
        Member member = null;
        if (principal != null) {
            member = memberService.findByEmail(principal.getName());
        } else {
            member = memberService.findByEmail(memberService.findByEmail("nonmember@example.com").getEmail());
        }

        Product product = productService.findById(id);
        List<Cart> cartList = cartService.findAll();

        boolean flag = true;

        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getProduct().getId() == product.getId()) {
                Cart cart = cartService.findById(Long.valueOf(i + 1));
                cart.setCartQuantity(cart.getCartQuantity() + quantity);
                cart.setCartPrice(cart.getProduct().getProductPrice() * cart.getCartQuantity());
                cart.setMember(member);
                cartService.saveCart(cart);
                flag = false;
                break;
            }
        }

        if (flag == true) {
            Cart cart = Cart.builder()
                    .cartQuantity(quantity)
                    .cartPrice(quantity * product.getProductPrice())
                    .product(product)
                    .member(member)
                    .build();
            cartService.saveCart(cart);
        }

        return "redirect:/cart";
    }

}
