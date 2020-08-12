package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.domain.Cart;
import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.shopadmin.service.ProductService;
import com.demo.demo0617.shopuser.service.CartService;
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
    private ProductService productService;


    @GetMapping("/cart")
    public String cartPage(Model model){

        List<Cart> cartList = cartService.findAll();
        model.addAttribute("cartList", cartList);

        return "/customer/cart";
    }

    @PostMapping("/cart")
    public String saveCart(Long id, int quantity){
        Product product = productService.findById(id);
        List<Cart> cartList = cartService.findAll();

        boolean flag = true;

        for(int i=0; i<cartList.size(); i++){
            if(cartList.get(i).getProduct().getId() == product.getId()){
                Cart cart = cartService.findById(Long.valueOf(i+1));
                cart.setCartQuantity(cart.getCartQuantity()+quantity);
                cart.setCartPrice(cart.getProduct().getProductPrice() * cart.getCartQuantity());
                cartService.saveCart(cart);
                flag = false;
                break;
            }
        }

        if(flag == true){
            Cart cart = Cart.builder()
                    .cartQuantity(quantity)
                    .cartPrice(quantity * product.getProductPrice())
                    .product(product)
                    .build();
            cartService.saveCart(cart);
        }

        return "redirect:/cart";
    }

}
