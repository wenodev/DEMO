package com.demo.demo0617.shopadmin.api;

import com.demo.demo0617.common.dto.CategoryDto;
import com.demo.demo0617.shopadmin.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
public class CategoryApiController {

    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
        categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok(categoryDto);
    }


}
