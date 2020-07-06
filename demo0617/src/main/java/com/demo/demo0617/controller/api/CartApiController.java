package com.demo.demo0617.controller.api;

import com.demo.demo0617.domain.Cart;
import com.demo.demo0617.domain.Product;
import com.demo.demo0617.dto.CartDto;
import com.demo.demo0617.service.CartService;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
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

        boolean flag = true;

        for(int i=0; i<cartList.size(); i++){

            System.out.println("cartList.get(i).getId() : " + cartList.get(i).getId() );
            System.out.println("product.get().getId() : " + product.get().getId());

             if(cartList.get(i).getId() == product.get().getId()){

                 Cart cart = cartService.findById(product.get().getId());
                 cart.setQuantity(cart.getQuantity()+quantity);

                 System.out.println("test");
                 cartService.saveCart(cart);

                 flag = false;
                 break;
             }
        }

        if(flag == true){
            Cart cart = Cart.builder()
                    .imgType(product.get().getImgType())
                    .productCode(product.get().getProductCode())
                    .productFileImg(product.get().getProductFileImg())
                    .productName(product.get().getProductName())
                    .productPrice(product.get().getProductPrice())
                    .productUrlImg(product.get().getProductUrlImg())
                    .quantity(quantity)
                    .product(product.get())
                    .build();
            cartService.saveCart(cart);
        }

        return "redirect:/cart";
    }

}
