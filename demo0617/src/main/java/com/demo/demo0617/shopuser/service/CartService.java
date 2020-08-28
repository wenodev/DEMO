package com.demo.demo0617.shopuser.service;

import com.demo.demo0617.common.domain.Cart;
import com.demo.demo0617.common.domain.CartRepository;
import com.demo.demo0617.common.domain.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CartService {

    private CartRepository cartRepository;

    @Transactional
    public List<Cart> findAll(){
        List<Cart> cartList = cartRepository.findAll();
        return cartList;
    }

    @Transactional
    public Cart findById(Long id){

        Optional<Cart> optional = cartRepository.findById(id);
        Cart cart = null;

        if(optional.isPresent()){
            cart = optional.get();
        }else{
            throw new RuntimeException("Cart not found for id : " + id);
        }
        return cart;

    }

    @Transactional
    public void saveCart(Cart cart){
        cartRepository.save(cart);
    }

    @Transactional
    public List<Cart> findByMember(Member member) {
        List<Cart> cartList = cartRepository.findByMember(member);
        return cartList;
    }
}
