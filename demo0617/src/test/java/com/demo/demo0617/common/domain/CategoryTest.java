package com.demo.demo0617.common.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class CategoryTest {


    @Test
    public void create(){
        Category category = Category.builder().categoryName("cate1").build();
        assertThat(category.getCategoryName(), is("cate1"));
    }

}