package com.demo.demo0617.shopuser.controller;

import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.common.dto.ProductDto;
import com.demo.demo0617.shopadmin.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    //index 페이지
    @Test
    public void indexTest() throws Exception {

        //given
        List<Product> mockProductList = new ArrayList<>();
        mockProductList.add(Product.builder()
                .id(11L).build());

        given(productService.findAll()).willReturn(mockProductList);


        //when
        mockMvc.perform(get("/"))
                .andExpect(view().name("/customer/index"))
                .andExpect(model().attributeExists("productList"))
                .andExpect(status().isOk());

        //then
        then(productService).should().findAll();
    }

    //상품 상세 페이지
    @Test
    public void productByIdTest() throws Exception {

        //given
        Long id = 11L;

        Product mockProduct = Product.builder()
                .id(id)
                .build();

        ProductDto mockProductDto = ProductDto.builder()
                .product(mockProduct)
                .build();


        given(productService.findById(id)).willReturn(mockProductDto);

        //when
        mockMvc.perform(get("/product/" + id))
                .andExpect(view().name("/customer/product"))
                .andExpect(model().attributeExists("product"))
                .andExpect(status().isOk());

        //then
        then(productService).should().findById(id);
    }

}