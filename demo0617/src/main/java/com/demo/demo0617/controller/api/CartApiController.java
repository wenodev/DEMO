package com.demo.demo0617.controller.api;

import com.demo.demo0617.domain.Cart;
import com.demo.demo0617.domain.Product;
import com.demo.demo0617.service.CartService;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class CartApiController {

    private CartService cartService;
    private ProductService productService;

    @PostMapping("/cart")
    public String saveCart(Long id, int quantity){
        Optional<Product> product = productService.findById(id);
        List<Cart> cartList = cartService.findAll();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        boolean flag = true;

        for(int i=0; i<cartList.size(); i++){

             if(cartList.get(i).getProduct().getId() == product.get().getId()){

                 Cart cart = cartService.findById(Long.valueOf(i+1));
                 cart.setCartQuantity(cart.getCartQuantity()+quantity);

                 cartService.saveCart(cart);

                 flag = false;
                 break;
             }
        }

        if(flag == true){
            Cart cart = Cart.builder()
                    .cartQuantity(quantity)
                    .product(product.get())
                    .build();
            cartService.saveCart(cart);
        }

        return "redirect:/cart";
    }

}
