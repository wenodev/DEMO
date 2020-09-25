package com.demo.demo0617.shopuser.service;

import com.demo.demo0617.common.domain.Cart;
import com.demo.demo0617.common.domain.CartRepository;
import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.domain.Product;
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
    public List<Cart> findAll() {
        List<Cart> cartList = cartRepository.findAll();
        return cartList;
    }

    @Transactional
    public Cart findById(Long id) {

        Optional<Cart> optional = cartRepository.findById(id);
        Cart cart = null;

        if (optional.isPresent()) {
            cart = optional.get();
        } else {
            throw new RuntimeException("Cart not found for id : " + id);
        }
        return cart;

    }

    @Transactional
    public void saveCart(Member member, Product product, int quantity) {

        // 기존에 카트에 담긴 상품이 있다면 갯수를 추가
        List<Cart> cartList = findByMember(member);
        boolean flag = true;
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i).getProduct().getId() == product.getId()) {
                Cart cart = findById(Long.valueOf(i + 1));
                cart.setCartQuantity(cart.getCartQuantity() + quantity);
                cart.setCartPrice(cart.getProduct().getProductPrice() * cart.getCartQuantity());
                cart.setMember(member);
                cartRepository.save(cart);
                flag = false;
                break;
            }
        }

        // 기존에 카트에 담긴 상품이 없음
        if (flag == true) {
            Cart cart = Cart.builder()
                    .cartQuantity(quantity)
                    .cartPrice(quantity * product.getProductPrice())
                    .product(product)
                    .member(member)
                    .build();
            cartRepository.save(cart);
        }

    }

    @Transactional
    public List<Cart> findByMember(Member member) {
        List<Cart> cartList = cartRepository.findByMember(member);
        return cartList;
    }

}
