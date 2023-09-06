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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ApiResponse<List<CategoryDto>> getAllCategories(){
        List<CategoryDto> categories = categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toBuilder)
                .collect(Collectors.toList());
        if (!categories.isEmpty()){
            return new ApiResponse<>(HttpStatus.OK.value(), "Categories retriived Success",categories);
        }else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "No Categories founds", null);
        }
    }

    public ApiResponse<CategoryDto> getCategoryById(Long id){

        Optional<Category> optianlCategory = categoryRepository.findById(id);

        if (optianlCategory.isPresent()){
            CategoryDto categoryDTO = CategoryMapper.toBuilder(optianlCategory.get());
            return new ApiResponse<>(HttpStatus.OK.value(), "category Found",categoryDTO);
        }else {
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "Category not found", null);
        }
    }
}
