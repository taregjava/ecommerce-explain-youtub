package com.halfacode.ecommerceyoutube.repoistory;

import com.halfacode.ecommerceyoutube.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
