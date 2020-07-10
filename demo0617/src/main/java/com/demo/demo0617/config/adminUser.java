package com.demo.demo0617.config;

import com.demo.demo0617.domain.Member;
import com.demo.demo0617.dto.AddressDto;
import com.demo.demo0617.dto.CategoryDto;
import com.demo.demo0617.dto.MemberDto;
import com.demo.demo0617.dto.ProductDto;
import com.demo.demo0617.service.AddressService;
import com.demo.demo0617.service.CategoryService;
import com.demo.demo0617.service.MemberService;
import com.demo.demo0617.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class adminUser implements CommandLineRunner {

    private MemberService memberService;
    private ProductService productService;
    private CategoryService categoryService;
    private AddressService addressService;

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


        Optional<Member> member = memberService.findByEmail(memberDto.getEmail());

        //주소 등록
        for (int num = 1; num <= 3; num++) {
            AddressDto addressDto = AddressDto.builder()
                    .address("주소1" + num)
                    .addressDetail("주소2" + num)
                    .comment("상세" + num)
                    .postalCode("12345" + num)
                    .member(member.get())
                    .build();
            addressService.saveAddress(addressDto);
        }


//        // 카테고리 등록
        for (int num = 1; num <= 5; num++) {
            CategoryDto categoryDto = CategoryDto.builder()
                    .categoryCode("CATE-CODE-" + num)
                    .categoryName("CATE-NAME-" + num)
                    .build();
            categoryService.saveCategory(categoryDto);
        }
//
//        //상품등록
        for (int i = 0; i < 10; i++) {
            ProductDto productDto = ProductDto.builder()
                    .productCode("Product-code" + i)
                    .productPrice(1000 + i)
                    .productName("Product" + i)
                    .imgType("url")
                    .quantity(100 + i)
                    .productUrlImg("https://i.imgur.com/Vpj0PxO.png")
                    .build();

            productService.saveProduct(productDto);
        }


    }
}
