package com.demo.demo0617.controller.api;

import com.demo.demo0617.domain.Address;
import com.demo.demo0617.domain.Member;
import com.demo.demo0617.dto.AddressDto;
import com.demo.demo0617.service.AddressService;
import com.demo.demo0617.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class AddressApiController {

    private AddressService addressService;
    private MemberService memberService;

    @PostMapping("/address")
    public Address savePost(@RequestBody Address address, Principal principal){

        Optional<Member> member = memberService.findByEmail(principal.getName());
        address.setMember(member.get());


        System.out.println("principal.getName() : " + principal.getName());
        System.out.println("member.get().getEmail() : " +  member.get().getEmail() );

        addressService.saveAddress(address);

        return address;
    }


}
