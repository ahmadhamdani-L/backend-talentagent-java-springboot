package com.backend.talentagent.repository;

import com.backend.talentagent.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long>{
    
}
