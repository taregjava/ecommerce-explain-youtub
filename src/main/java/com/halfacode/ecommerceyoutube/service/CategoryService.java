package com.halfacode.ecommerceyoutube.service;

import com.halfacode.ecommerceyoutube.dto.ApiResponse;
import com.halfacode.ecommerceyoutube.dto.CategoryDto;
import com.halfacode.ecommerceyoutube.entity.Category;
import com.halfacode.ecommerceyoutube.mapper.CategoryMapper;
import com.halfacode.ecommerceyoutube.repoistory.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public ApiResponse<CategoryDto> saveCategory(CategoryDto categoryDto){
        Category category= CategoryMapper.toEntity(categoryDto)  ;
        Category saveCategory = categoryRepository.save(category);

        CategoryDto saveCategoryDto= CategoryMapper.toBuilder(saveCategory);
        return new ApiResponse<>(HttpStatus.CREATED.value(),"Category saved Success",saveCategoryDto);
    }
}
