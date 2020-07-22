package com.demo.demo0617.shopuser.service;


import com.demo.demo0617.common.domain.Address;
import com.demo.demo0617.common.domain.AddressRepository;
import com.demo.demo0617.common.dto.AddressDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Transactional
    public Address saveAddress(AddressDto addressDto) {
        return addressRepository.save(addressDto.toEntity());
    }

    @Transactional
    public Address findById(Long id){
        Optional<Address> optional = addressRepository.findById(id);
        Address address = null;
        if (optional.isPresent()){
            address = optional.get();
        }else{
            throw new RuntimeException("Address not found for id : " + id);
        }
        return address;
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
