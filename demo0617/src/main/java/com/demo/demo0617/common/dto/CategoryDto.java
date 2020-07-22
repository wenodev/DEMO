package com.demo.demo0617.common.dto;

import com.demo.demo0617.common.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class CategoryDto {

    private Long id;
    private String categoryCode;
    private String categoryName;

    public Category toEntity(){
        return Category.builder()
                .id(id)
                .categoryCode(categoryCode)
                .categoryName(categoryName)
                .build();
    }

    @Builder
    public CategoryDto(Long id, String categoryCode, String categoryName){
        this.id = id;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }


}
