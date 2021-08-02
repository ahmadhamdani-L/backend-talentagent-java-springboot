package com.backend.talentagent.services;

import java.util.List;
import java.util.Optional;

import com.backend.talentagent.models.Category;

public interface CategoryService {
    //show list all categogry
    List<Category> findAllCategory();
    
    // insert object category ke db
    Category addCategory(Category category);

    // cari data category sesuai id yg dikirim
    Optional<Category> findCategoryById(Long id);

    // delete category sesuai id yg dikirim
    void deleteCategoryById(Long id);
}

