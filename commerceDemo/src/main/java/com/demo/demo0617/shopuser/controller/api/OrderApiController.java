package com.demo.demo0617.shopuser.controller.api;

import com.demo.demo0617.common.domain.Address;
import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.domain.Orders;
import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.shopadmin.service.ProductService;
import com.demo.demo0617.shopuser.service.AddressService;
import com.demo.demo0617.shopuser.service.MemberService;
import com.demo.demo0617.shopuser.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class OrderApiController {

    private ProductService productService;
    private MemberService memberService;
    private AddressService addressService;
    private OrderService orderService;

    @PostMapping("/order")
    public void saveOrder(@RequestParam(value="quantity[]", required=true) List<Integer> quantity, @RequestParam(value="totalPrice[]", required=true)  List<Float> totalPrice, Long memberId, Long addressId, @RequestParam(value="productId[]", required=true) List<Long> productId){

        Member member = memberService.findById(memberId);
        Address address = addressService.findById(addressId);

        System.out.println("productId.size() : " + productId.size());

        System.out.println("productId : " + productId);
        System.out.println("quantity : " + quantity);

        int orderNumber = makeRandom();

        for(int i=0; i<productId.size(); i++){
            Product product = productService.findById(productId.get(i));
            Orders order = Orders.builder()
                    .orderNumber("order-" + orderNumber)
                    .quantity(quantity.get(i))
                    .totalPrice(totalPrice.get(i))
                    .member(member)
                    .product(product)
                    .address(address)
                    .build();
            orderService.saveOrder(order);
        }
    }

    //주문번호 생성
    public int makeRandom(){
        return (int)(Math.random()*1000000000) % 10000;
    }

}
