package com.demo.demo0617.shopadmin.service;

import com.demo.demo0617.common.domain.Category;
import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.common.domain.ProductRepository;
import com.demo.demo0617.common.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;


    @Transactional
    public void saveProduct(Map<String, Object> productResource) {
        Long categoryId = Long.valueOf((String) productResource.get("categoryId"));
        Category category = categoryService.findById(categoryId);

        LinkedHashMap linkedHashMap = (LinkedHashMap) productResource.get("productDto");
        Product product = Product.builder()
                .productCode((String) linkedHashMap.get("productCode"))
                .productName((String) linkedHashMap.get("productName"))
                .productPrice(Float.valueOf((String)linkedHashMap.get("productPrice")))
                .quantity(Integer.valueOf((String)linkedHashMap.get("quantity")))
                .productUrlImg((String) linkedHashMap.get("productUrlImg"))
                .category(category)
                .build();

        ProductDto productDto = ProductDto.builder()
                .product(product)
                .build();

        productRepository.save(productDto.toEntity());
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
