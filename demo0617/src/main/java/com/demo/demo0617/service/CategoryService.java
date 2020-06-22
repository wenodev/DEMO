package com.demo.demo0617.service;

import com.demo.demo0617.domain.Category;
import com.demo.demo0617.domain.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Category saveCategory(Category category) {
        System.out.println("In Service : "+category.getName());
        return categoryRepository.save(category);
    }


}
