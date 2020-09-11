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
import org.springframework.web.bind.annotation.*;

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

        List<Orders> orderList = new ArrayList<>();
        float subTotal = 0;

        int sumOfQuantity = quantity.stream().mapToInt(n -> n).sum();


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
        model.addAttribute("sumOfQuantity", sumOfQuantity);


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
        model.addAttribute("sumOfQuantity", quantity);


        return "/customer/order";
    }


    @PostMapping("/order")
    public String saveOrder(@RequestParam(value="quantity[]", required=true) List<Integer> quantity, @RequestParam(value="totalPrice[]", required=true)  List<Float> totalPrice, Long memberId, Long addressId, @RequestParam(value="productId[]", required=true) List<Long> productId){


        System.out.println("saveOrderController memberId : " + memberId);

        Member member = memberService.findById(memberId);
        Address address = addressService.findById(addressId);

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
        return "/customer/order-complete";
    }

    //주문번호 생성
    public int makeRandom(){
        return (int)(Math.random()*1000000000) % 10000;
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

