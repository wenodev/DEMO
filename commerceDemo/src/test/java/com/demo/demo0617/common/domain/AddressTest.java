package com.demo.demo0617.common.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class AddressTest {

    @Test
    public void creation(){
        Address address = Address.builder().address("address1").build();
        assertThat(address.getAddress(), is("address1"));
    }


}