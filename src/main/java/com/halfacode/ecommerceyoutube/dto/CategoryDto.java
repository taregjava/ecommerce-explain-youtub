package com.halfacode.ecommerceyoutube.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

    private Long id;
    private String name;
    private String imagePath;  // toDoSave image

    private boolean flag;
}
