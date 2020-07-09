package com.demo.demo0617.controller.api;

import com.demo.demo0617.domain.Orders;
import com.demo.demo0617.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class OrderApiController {

    private OrderService orderService;

//    @PostMapping("/order")
//    public Orders saveOrder(@RequestBody Orders order){
//        System.out.println("order : " + order);
//        return order;
//    }

    @PostMapping("/order")
    public void saveOrder(String quantity, String totalPrice){

        System.out.println("quantity : " + quantity);
        System.out.println("totalPrice : " + totalPrice);

    }

}
