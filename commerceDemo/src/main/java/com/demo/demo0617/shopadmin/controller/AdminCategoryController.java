package com.demo.demo0617.shopadmin.controller;

import com.demo.demo0617.common.domain.Category;
import com.demo.demo0617.common.dto.CategoryDto;
import com.demo.demo0617.shopadmin.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Controller
public class AdminCategoryController {

    private CategoryService categoryService;

    @GetMapping("/admin/category-register")
    public String showCategory(){
        return "/admin/category-register";
    }

    @PostMapping("/category")
    public Category saveCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.saveCategory(categoryDto);
    }

}
