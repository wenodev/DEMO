package com.demo.demo0617.service;

import com.demo.demo0617.domain.Cart;
import com.demo.demo0617.domain.CartRepository;
import com.demo.demo0617.domain.Product;
import com.demo.demo0617.dto.CartDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class CartService {

    private CartRepository cartRepository;


    @Transactional
    public List<Cart> findAll(){
        List<Cart> cartList = cartRepository.findAll();
        return cartList;
    }


    public Cart findById(Long id){
        return cartRepository.findById(id).get();
    }



    @Transactional
    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }



}
