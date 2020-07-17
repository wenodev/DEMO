package com.demo.demo0617.service;

import com.demo.demo0617.domain.Product;
import com.demo.demo0617.domain.ProductRepository;
import com.demo.demo0617.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public Long saveProduct(ProductDto productDto){
        return productRepository.save(productDto.toEntity()).getId();
    }

    @Transactional
    public List<Product> findAll(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

}
