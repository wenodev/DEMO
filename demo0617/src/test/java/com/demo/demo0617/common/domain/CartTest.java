package com.demo.demo0617.common.domain;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CartTest{

    @Test
    public void create(){
        Cart cart = Cart.builder().cartQuantity(5).build();
        assertThat(cart.getCartQuantity(), is(5));
    }

}