package com.demo.demo0617.controller.api;

import com.demo.demo0617.domain.Address;
import com.demo.demo0617.domain.Member;
import com.demo.demo0617.domain.Orders;
import com.demo.demo0617.domain.Product;
import com.demo.demo0617.service.AddressService;
import com.demo.demo0617.service.MemberService;
import com.demo.demo0617.service.OrderService;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class OrderApiController {

    private OrderService orderService;
    private MemberService memberService;
    private AddressService addressService;
    private ProductService productService;

    @PostMapping("/order")
    public void saveOrder(int quantity, float totalPrice, Long memberId, Long addressId, @RequestParam(value="productId[]", required=true)  List<Long> productId){

//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Member member = memberService.findById(memberId);
        Address address = addressService.findById(addressId);


        for(int i=0; i<productId.size(); i++){
            Product product = productService.findById(productId.get(i));

            Orders order = Orders.builder()
                    .quantity(quantity)
                    .totalPrice(totalPrice)
                    .member(member)
                    .product(product)
                    .address(address)
                    .build();
            orderService.saveOrder(order);
        }


    }

}
