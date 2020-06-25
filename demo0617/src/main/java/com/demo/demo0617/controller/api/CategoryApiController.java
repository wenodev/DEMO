package com.demo.demo0617.controller.api;

import com.demo.demo0617.dto.CategoryDto;
import com.demo.demo0617.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
public class CategoryApiController {

    private CategoryService categoryService;

    @PostMapping("/category")
    public CategoryDto saveCategory(@RequestBody CategoryDto categoryDto){
        System.out.println("In Controller : "+categoryDto.getCategoryName());
        categoryService.saveCategory(categoryDto);

        return categoryDto;
    }


}
