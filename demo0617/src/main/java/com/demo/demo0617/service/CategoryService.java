package com.demo.demo0617.service;

import com.demo.demo0617.domain.Category;
import com.demo.demo0617.domain.CategoryRepository;
import com.demo.demo0617.dto.CategoryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Category saveCategory(CategoryDto categoryDto) {
        return categoryRepository.save(categoryDto.toEntity());
    }


}
