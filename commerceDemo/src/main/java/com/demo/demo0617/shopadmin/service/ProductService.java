package com.demo.demo0617.shopadmin.service;

import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.common.domain.ProductRepository;
import com.demo.demo0617.common.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Product findById(Long id) {

        Optional<Product> optional = productRepository.findById(id);
        Product product = null;

        if (optional.isPresent()){
            product = optional.get();
        }else{
            throw new RuntimeException("Product not found for id : " + id);
        }
        return product;
    }

    @Transactional
    public int findTableNumber(){
        List<Product> productList = productRepository.findAll();
        return productList.size();
    }


}
