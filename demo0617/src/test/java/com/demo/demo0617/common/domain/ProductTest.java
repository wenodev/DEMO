package com.demo.demo0617.common.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProductTest {

    @Test
    public void create(){
        Product product = Product.builder().productName("product1").build();
        assertThat(product.getProductName(), is("product1"));
    }


}