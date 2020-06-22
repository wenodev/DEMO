package com.demo.demo0617.service;

import com.demo.demo0617.domain.Product;
import com.demo.demo0617.domain.ProductRepository;
import com.demo.demo0617.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    @Transactional
    public Long saveProduct(ProductDto productDto){
        return productRepository.save(productDto.toEntity()).getId();
    }

    @Transactional
    public List<Product> findAll(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

}
