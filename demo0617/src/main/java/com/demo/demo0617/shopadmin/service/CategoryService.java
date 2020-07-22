package com.demo.demo0617.shopadmin.service;

import com.demo.demo0617.common.domain.Category;
import com.demo.demo0617.common.domain.CategoryRepository;
import com.demo.demo0617.common.dto.CategoryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    @Transactional
    public Category saveCategory(CategoryDto categoryDto) {
        return categoryRepository.save(categoryDto.toEntity());
    }

    @Transactional
    public List<Category> findAll(){
       return categoryRepository.findAll();
    }


    @Transactional
    public Category findById(Long id){

        Optional<Category> optional = categoryRepository.findById(id);
        Category category = null;

        if(optional.isPresent()){
            category = optional.get();
        }else{
            throw new RuntimeException("Product not found for id : " + id);
        }

        return category;
    }

}
