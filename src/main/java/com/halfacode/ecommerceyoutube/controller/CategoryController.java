package com.halfacode.ecommerceyoutube.controller;

import com.halfacode.ecommerceyoutube.dto.ApiResponse;
import com.halfacode.ecommerceyoutube.dto.CategoryDto;
import com.halfacode.ecommerceyoutube.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryDto>> createCategory(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.saveCategory(categoryDto));
    }
}
