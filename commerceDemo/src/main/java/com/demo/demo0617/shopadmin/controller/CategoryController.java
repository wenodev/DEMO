package com.demo.demo0617.shopadmin.controller;

import com.demo.demo0617.common.dto.CategoryDto;
import com.demo.demo0617.shopadmin.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@AllArgsConstructor
@Controller
public class CategoryController {

    private CategoryService categoryService;

    @GetMapping("/admin/category-register")
    public String showCategory(){
        return "/admin/category-register";
    }

    @PostMapping("/category")
    public @ResponseBody ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok(categoryDto);
    }

}
