package com.demo.demo0617.shopadmin.service;

import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.common.domain.ProductRepository;
import com.demo.demo0617.common.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;

    @Transactional
    public void saveProduct(Map<String, Object> productDtoIntegerMap){


        for (Map.Entry<String, Object> entry : productDtoIntegerMap.entrySet()){
            System.out.println("KEY : " + entry.getKey());
            System.out.println("VALUE : " + entry.getValue());
        }

        Long categoryId = Long.valueOf((String) productDtoIntegerMap.get("categoryId"));
        System.out.println(categoryId);


        Object productDtoTemp = productDtoIntegerMap.get("productDto");
        ProductDto productDto = (ProductDto) productDtoTemp;

        System.out.println(productDto);


    }

    @Transactional
    public List<Product> findAll(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Transactional
    public ProductDto findById(Long id) {

        Optional<Product> optional = productRepository.findById(id);
        Product product = null;

        if (optional.isPresent()){
            product = optional.get();
        }else{
            throw new RuntimeException("Product not found for id : " + id);
        }
        return ProductDto.builder().product(product).build();
    }

    @Transactional
    public int findTableNumber(){
        List<Product> productList = productRepository.findAll();
        return productList.size();
    }


}
