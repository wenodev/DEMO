package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.domain.Address;
import com.demo.demo0617.shopuser.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class AddressController {

    private AddressService addressService;

    @GetMapping("/address")
    public String addressList(Model model){
        List<Address> addressList = addressService.findAll();
        model.addAttribute("addressList", addressList);
        return "/customer/address-list";
    }

    @GetMapping("/address/add")
    public String addressAdd(Model model){
        List<Address> addressList = addressService.findAll();
        model.addAttribute("addressList", addressList);
        return "/customer/address-add";
    }



}
