package com.demo.demo0617.config;

import com.demo.demo0617.dto.CategoryDto;
import com.demo.demo0617.dto.MemberDto;
import com.demo.demo0617.dto.ProductDto;
import com.demo.demo0617.service.CategoryService;
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
    private CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {

        //관리자 등록
        MemberDto adminDto = MemberDto.builder()
                .email("admin@example.com")
                .password("1234")
                .name("admin")
                .build();

        memberService.joinUser(adminDto);


        //사용자 등록
        MemberDto memberDto = MemberDto.builder()
                .email("user1@example.com")
                .password("1234")
                .name("user1")
                .build();

        memberService.joinUser(memberDto);


        //상품등록


        for (int i = 0; i < 10; i++) {

            ProductDto productDto = ProductDto.builder()
                    .productCode("Product-code" + i)
                    .productPrice("100")
                    .productName("Product" + i)
                    .imgType("url")
                    .quantity("100")
                    .productUrlImg("https://i.imgur.com/Vpj0PxO.png")
                    .build();

            productService.saveProduct(productDto);
        }


        // 카테고리 등록

        for (int num = 1; num <= 5; num++) {
            CategoryDto categoryDto = CategoryDto.builder()
                    .categoryCode("CATE-CODE-" + num)
                    .categoryName("CATE-NAME-" + num)
                    .build();
            categoryService.saveCategory(categoryDto);
        }


    }
}
