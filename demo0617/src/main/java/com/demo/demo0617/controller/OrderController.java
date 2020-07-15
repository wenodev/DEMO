package com.demo.demo0617.controller;

import com.demo.demo0617.domain.Address;
import com.demo.demo0617.domain.Member;
import com.demo.demo0617.domain.Orders;
import com.demo.demo0617.domain.Product;
import com.demo.demo0617.service.AddressService;
import com.demo.demo0617.service.MemberService;
import com.demo.demo0617.service.OrderService;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class OrderController {

    private ProductService productService;
    private MemberService memberService;
    private AddressService addressService;
    private OrderService orderService;

    @PostMapping("/order/{id}")
    public String orderById(Principal principal, Model model, @PathVariable Long id, int quantity ){

        Optional<Product> productDto = productService.findById(id);
        productDto.get().setQuantity(quantity);

        Optional<Member> member = memberService.findByEmail(principal.getName());
        List<Address> address = addressService.findByMemberId(member.get().getId());

        model.addAttribute("member", member.get());
        model.addAttribute("addressList", address);
        model.addAttribute("product", productDto.get());

        return "/customer/order";
    }


    @GetMapping("/order/complete")
    public String orderComplete() {
        return "/customer/order-complete";
    }

    @GetMapping("/order/list")
    public String orderList(Model model){

        List<Orders> ordersList = orderService.findAll();
        System.out.println("ordersList.get(0).getOrderNumber() : " + ordersList.get(0).getOrderNumber());

        model.addAttribute("ordersList", ordersList);

        System.out.println("====주문 내역 페이지 시작=====");

        return "/customer/order-list";
    }


}

