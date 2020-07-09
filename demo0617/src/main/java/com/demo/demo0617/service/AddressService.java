package com.demo.demo0617.service;


import com.demo.demo0617.domain.Address;
import com.demo.demo0617.domain.AddressRepository;
import com.demo.demo0617.dto.AddressDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Transactional
    public Address saveAddress(AddressDto addressDto) {
        System.out.println("In Service : "+addressDto.getAddress());
        return addressRepository.save(addressDto.toEntity());
    }

    @Transactional
    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    @Transactional
    public List<Address> findByMemberId(Long id) {
        return addressRepository.findByMemberId(id);
    }



}
