package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.domain.Address;
import com.demo.demo0617.common.domain.Orders;
import com.demo.demo0617.common.dto.MemberDto;
import com.demo.demo0617.common.dto.OrdersDto;
import com.demo.demo0617.shopuser.service.AddressService;
import com.demo.demo0617.shopuser.service.MemberService;
import com.demo.demo0617.shopuser.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@Controller
public class OrderController {

    private MemberService memberService;
    private AddressService addressService;
    private OrderService orderService;

    //카트페이지에서 주문페이지 이동
    @PostMapping("/orderFromCart")
    public String orderFromCart(
            Principal principal, Model model,
            @RequestParam(value="id", required=true) List<Long> id,
            @RequestParam(value="quantity", required=true) List<Integer> quantity ){


        List<Orders> orderList = orderService.orderFromCart(id, quantity);
        float subTotal = orderService.getSubTotal(id, quantity);
        int sumOfQuantity = orderService.getSumOfQuantity(quantity);
        MemberDto memberDto = memberService.findByEmail(principal.getName());
        List<Address> address = addressService.findByMemberId(memberDto.getId());

        model.addAttribute("member", memberDto);
        model.addAttribute("addressList", address);
        model.addAttribute("orderList", orderList);
        model.addAttribute("subTotal", subTotal);
        model.addAttribute("sumOfQuantity", sumOfQuantity);

        return "/customer/order";
    }

    //상품페이지에서 주문페이지 이동
    @PostMapping("/order/{productId}")
    public String orderById(Principal principal, Model model, @PathVariable Long productId, int productQuantity) {

        System.out.println("OrderController orderById ");


        OrdersDto ordersDto = orderService.readyForOrder(productId, productQuantity);
        MemberDto memberDto = memberService.findByEmail(principal.getName());
        List<Address> address = addressService.findByMemberId(memberDto.getId());

        model.addAttribute("member", memberDto);
        model.addAttribute("addressList", address);
        model.addAttribute("orderList", ordersDto);
        model.addAttribute("subTotal", ordersDto.getTotalPrice());
        model.addAttribute("sumOfQuantity", productQuantity);

        return "/customer/order";
    }


    //paypal 완료 후 처리
    @PostMapping("/order")
    public String saveOrder( @RequestParam(value="productId[]", required=true) List<Long> productId,  @RequestParam(value="quantity[]", required=true) List<Integer> quantity, @RequestParam(value="totalPrice[]", required=true)  List<Float> totalPrice, Long memberId, Long addressId){

        orderService.saveOrders(productId, quantity, totalPrice, memberId, addressId);

        return "/customer/order-complete";
    }


    @GetMapping("/order/complete")
    public String orderComplete() {
        return "/customer/order-complete";
    }

    @GetMapping("/order/list")
    public String orderList(Model model) {
        List<Orders> ordersList = orderService.findAll();
        String isZero = "";

        if(ordersList.size() == 0){
            isZero = "YES";
            model.addAttribute("isZero", isZero);
        }else{
            isZero = "NO";
            model.addAttribute("isZero", isZero);
            model.addAttribute("ordersList", ordersList);
        }
        return "/customer/order-list";
    }

}

