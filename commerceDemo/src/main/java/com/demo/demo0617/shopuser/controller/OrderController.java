package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.domain.Address;
import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.domain.Orders;
import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.common.dto.OrdersDto;
import com.demo.demo0617.common.dto.ProductDto;
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

    //카트페이지에서 주문페이지 이동
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

    //상품페이지에서 주문페이지 이동
    @PostMapping("/order/{id}")
    public String orderById(Principal principal, Model model, @PathVariable Long productId, int productQuantity) {

        OrdersDto ordersDto = orderService.readyForOrder(productId, productQuantity);
        Member member = memberService.findByEmail(principal.getName());
        List<Address> address = addressService.findByMemberId(member.getId());

        model.addAttribute("member", member);
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


        Member member = memberService.findById(memberId);
        Address address = addressService.findById(addressId);


        for(int i=0; i<productId.size(); i++){
            ProductDto productDto = productService.findById(productId.get(i));
            OrdersDto orderDto = OrdersDto.builder()
                    .orderNumber("order-" + orderNumber)
                    .quantity(quantity.get(i))
                    .totalPrice(totalPrice.get(i))
                    .member(member)
                    .product(productDto.toEntity())
                    .address(address)
                    .build();
            orderService.saveOrder(order);
        }
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

