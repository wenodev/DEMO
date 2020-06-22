package com.demo.demo0617.controller;


import com.demo.demo0617.domain.Category;
import com.demo.demo0617.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
public class CategoryController {

    private CategoryService categoryService;

    @PostMapping("/category")
    public String saveCategory(String name){
        Category category = Category.builder()
                .name(name)
                .build();
        System.out.println("In Controller : "+category.getName());
        categoryService.saveCategory(category);
         return "redirect:/admin/product-list";
    }


}
