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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class OrderApiController {

    private OrderService orderService;
    private MemberService memberService;
    private AddressService addressService;
    private ProductService productService;

//    @PostMapping("/order")
//    public Orders saveOrder(@RequestBody Orders order){
//        System.out.println("order : " + order);
//        return order;
//    }

    @PostMapping("/order")
    public void saveOrder(int quantity, float totalPrice, Long memberId, Long addressId, Long productId){

        System.out.println("quantity : " + quantity);
        System.out.println("totalPrice : " + totalPrice);
        System.out.println("memberId : " + memberId);
        System.out.println("addressId : " + addressId);
        System.out.println("productId : " + productId);


        Optional<Member> member = memberService.findById(memberId);
        Optional<Address> address = addressService.findById(addressId);
        Optional<Product> product = productService.findById(productId);

        Orders order = Orders.builder()
                .quantity(quantity)
                .totalPrice(totalPrice)
                .member(member.get())
                .product(product.get())
                .address(address.get())
                .build();

        orderService.saveOrder(order);

    }

}
