package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.domain.Address;
import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.dto.AddressDto;
import com.demo.demo0617.shopuser.service.AddressService;
import com.demo.demo0617.shopuser.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@Controller
public class AddressController {

    private AddressService addressService;
    private MemberService memberService;

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

    @PostMapping("/address")
    public @ResponseBody AddressDto savePost(@RequestBody AddressDto addressDto, Principal principal){

        Member member = memberService.findByEmail(principal.getName());
        addressDto.setMember(member);

        addressService.saveAddress(addressDto);

        return addressDto;
    }

}
