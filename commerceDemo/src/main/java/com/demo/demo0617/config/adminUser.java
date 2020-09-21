package com.demo.demo0617.config;

import com.demo.demo0617.common.domain.Address;
import com.demo.demo0617.common.domain.Category;
import com.demo.demo0617.common.domain.Member;
import com.demo.demo0617.common.domain.Product;
import com.demo.demo0617.common.dto.AddressDto;
import com.demo.demo0617.common.dto.CategoryDto;
import com.demo.demo0617.common.dto.MemberDto;
import com.demo.demo0617.common.dto.ProductDto;
import com.demo.demo0617.shopadmin.service.CategoryService;
import com.demo.demo0617.shopadmin.service.ProductService;
import com.demo.demo0617.shopuser.service.AddressService;
import com.demo.demo0617.shopuser.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        Member admin = Member.builder()
                .email("admin@example.com")
                .password("1234")
                .name("admin")
                .build();

        MemberDto adminDto = MemberDto.builder()
                .member(admin)
                .build();
        memberService.joinUser(adminDto);


        //회원 등록
        Member member = Member.builder()
                .email("user1@example.com")
                .password("1234")
                .name("user1")
                .build();

        MemberDto memberDto = MemberDto.builder()
                .member(member)
                .build();
        memberService.joinUser(memberDto);


        //주소 등록
        MemberDto memberDtoForAddress = memberService.findByEmail(memberDto.getEmail());
        List<Address> addressList = new ArrayList<>();
        for (int num = 1; num <= 2; num++) {
            Address address = Address.builder()
                    .address("주소1" + num)
                    .addressDetail("주소2" + num)
                    .comment("상세" + num)
                    .postalCode("12345" + num)
                    .addressMemberName("name" + num)
                    .member(memberDtoForAddress.toEntity())
                    .build();

            AddressDto addressDto = AddressDto.builder()
                    .address(address)
                    .build();

            addressList.add(addressDto.toEntity());
        }

        addressService.saveAll(addressList);



        // 카테고리 등록
        for (int num = 1; num <= 5; num++) {
            CategoryDto categoryDto = CategoryDto.builder()
                    .categoryCode("CATE-CODE-" + num)
                    .categoryName("CATE-NAME-" + num)
                    .build();
            categoryService.saveCategory(categoryDto);
        }

        //상품등록
        Category category = categoryService.findById(1L);
        for (int i = 1; i <= 10; i++) {
            Product product = Product.builder()
                    .productCode("Product-code" + i)
                    .productPrice(1000 + i)
                    .productName("Product" + i)
                    .imgType("url")
                    .quantity(100 + i)
                    .category(category)
                    .productDescription("Product-Description" + i)
                    .productUrlImg("https://i.imgur.com/Vpj0PxO.png")
                    .build();

            ProductDto productDto = ProductDto.builder()
                    .product(product)
                    .build();

            productService.saveProduct(productDto);
        }

    }
}
