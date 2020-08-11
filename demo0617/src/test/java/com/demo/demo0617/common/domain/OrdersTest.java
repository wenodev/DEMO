package com.demo.demo0617.common.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class OrdersTest {

    @Test
    public void create(){
        Orders orders = Orders.builder().orderNumber("order1").build();
        assertThat(orders.getOrderNumber(), is("order1"));
    }

}