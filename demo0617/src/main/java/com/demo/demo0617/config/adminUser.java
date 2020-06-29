package com.demo.demo0617.config;

import com.demo.demo0617.dto.MemberDto;
import com.demo.demo0617.dto.ProductDto;
import com.demo.demo0617.service.MemberService;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class adminUser implements CommandLineRunner {

    private MemberService memberService;
    private ProductService productService;

    @Override
    public void run(String... args) throws Exception {

        MemberDto adminDto = MemberDto.builder()
                .email("admin@example.com")
                .password("1234")
                .name("admin")
                .build();

        memberService.joinUser(adminDto);

        MemberDto memberDto = MemberDto.builder()
                .email("user1@example.com")
                .password("1234")
                .name("user1")
                .build();

        memberService.joinUser(memberDto);







        ProductDto productDto = ProductDto.builder()
                .productCode("Product1-code")
                .productPrice("100")
                .productName("Product1")
                .imgType("url")
                .productUrlImg("https://i.imgur.com/Vpj0PxO.png")
                .build();

        for(int i=0; i<10; i++){
            productService.saveProduct(productDto);
        }

    }
}
