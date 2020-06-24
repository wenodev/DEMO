package com.demo.demo0617.controller;

import com.demo.demo0617.domain.Product;
import com.demo.demo0617.dto.ProductDto;
import com.demo.demo0617.service.MemberService;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Optional;

@AllArgsConstructor
@Controller
public class OrderController {

    private ProductService productService;
    private MemberService memberService;



    @GetMapping("/order/{id}")
    public String orderById(Model model, @PathVariable Long id, String quantity){

        Optional<Product> productDto = productService.findById(id);

        model.addAttribute("product", productDto.get());
        model.addAttribute("quantity", quantity);

        return "order";
    }

    @PostMapping("/order")
    public String orderProducts(){


        return "redirect:/login";
    }




}
