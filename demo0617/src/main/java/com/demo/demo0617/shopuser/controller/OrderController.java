package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.domain.Address;
import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.domain.Orders;
import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.shopadmin.service.ProductService;
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
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Controller
public class OrderController {

    private ProductService productService;
    private MemberService memberService;
    private AddressService addressService;
    private OrderService orderService;

    @PostMapping("/orderFromCart")
    public String orderFromCart(
            Principal principal, Model model,
            @RequestParam(value="id", required=true) List<Long> id,
            @RequestParam(value="quantity", required=true) List<Integer> quantity ){


        System.out.println("orderFromCart 확인");

        List<Orders> orderList = new ArrayList<>();
        float subTotal = 0;


        for(int i=0; i<id.size(); i++){

            Product product = productService.findById(id.get(i));

            Orders orders = Orders.builder()
                    .product(product)
                    .quantity(quantity.get(i))
                    .totalPrice(product.getProductPrice() * quantity.get(i))
                    .build();

            orderList.add(orders);

            subTotal += orders.getTotalPrice();
        }






        Member member = memberService.findByEmail(principal.getName());
        List<Address> address = addressService.findByMemberId(member.getId());

        model.addAttribute("member", member);
        model.addAttribute("addressList", address);
        model.addAttribute("orderList", orderList);
        model.addAttribute("subTotal", subTotal);


        return "/customer/order";
    }

    @PostMapping("/order/{id}")
    public String orderById(Principal principal, Model model, @PathVariable Long id, int quantity) {

        System.out.println("id : " + id);
        System.out.println("quantity : " + quantity);

        Product productDto = productService.findById(id);
        float subTotal = 0;

        Orders orders = Orders.builder()
                .quantity(quantity)
                .totalPrice(productDto.getProductPrice() * quantity)
                .product(productDto)
                .build();

        Member member = memberService.findByEmail(principal.getName());
        List<Address> address = addressService.findByMemberId(member.getId());
        subTotal = orders.getTotalPrice();

        model.addAttribute("member", member);
        model.addAttribute("addressList", address);
        model.addAttribute("orderList", orders);
        model.addAttribute("subTotal", subTotal);


        return "/customer/order";
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

