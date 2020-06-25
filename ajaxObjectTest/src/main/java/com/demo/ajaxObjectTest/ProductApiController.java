package com.demo.ajaxObjectTest;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ProductApiController {

    private ProductService productService;

    @PostMapping("/product")
    public Product registerProduct(@RequestBody Product product){
        productService.save(product);
        return product;
    }


}
