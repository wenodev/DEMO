package com.demo.ajaxObjectTest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

}
