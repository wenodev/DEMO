package com.demo.demo0617.controller;

import com.demo.demo0617.domain.Address;
import com.demo.demo0617.domain.Member;
import com.demo.demo0617.domain.Product;
import com.demo.demo0617.service.AddressService;
import com.demo.demo0617.service.MemberService;
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

    @PostMapping("/order/{id}")
    public String orderById(Principal principal, Model model, @PathVariable Long id, int quantity ){

        System.out.println("productId : " + id);
        System.out.println("quantity : " + quantity);


        Optional<Product> productDto = productService.findById(id);
        productDto.get().setQuantity(quantity);


        System.out.println("principal.getName() : " + principal.getName());

        Optional<Member> member = memberService.findByEmail(principal.getName());

        List<Address> address = addressService.findByMemberId(member.get().getId());


        System.out.println("member name : " + member.get().getName());
        System.out.println("member address : " + address.get(0).getAddress());


        model.addAttribute("product", productDto.get());

        return "/customer/order";
    }

    @GetMapping("/order/complete")
    public String orderComplete() {
        return "/customer/order-complete";
    }

}

