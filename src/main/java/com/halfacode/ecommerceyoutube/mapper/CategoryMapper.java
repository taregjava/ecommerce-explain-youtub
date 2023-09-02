package com.halfacode.ecommerceyoutube.mapper;

import com.halfacode.ecommerceyoutube.dto.CategoryDto;
import com.halfacode.ecommerceyoutube.entity.Category;

public class CategoryMapper {


    public static Category toEntity(CategoryDto dto){

        Category category= new Category();
        category.setName(dto.getName());
        category.setImagePath(dto.getImagePath());
       category.setFlag(dto.isFlag());

       return category;
    }

    public static CategoryDto toBuilder(Category saveCategory) {
        return CategoryDto.builder().
                id(saveCategory.getId())
                        .name(saveCategory.getName())
                                .imagePath(saveCategory.getImagePath())
                                        .flag(saveCategory.isFlag())
                .build();
    }
}
