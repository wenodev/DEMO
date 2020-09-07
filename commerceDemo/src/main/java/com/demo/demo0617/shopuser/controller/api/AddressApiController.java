package com.demo.demo0617.shopuser.controller.api;

import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.dto.AddressDto;
import com.demo.demo0617.shopuser.service.AddressService;
import com.demo.demo0617.shopuser.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@AllArgsConstructor
@RestController
public class AddressApiController {

    private AddressService addressService;
    private MemberService memberService;

    @PostMapping("/address")
    public AddressDto savePost(@RequestBody AddressDto addressDto, Principal principal){

        Member member = memberService.findByEmail(principal.getName());
        addressDto.setMember(member);

        addressService.saveAddress(addressDto);

        return addressDto;
    }


}
