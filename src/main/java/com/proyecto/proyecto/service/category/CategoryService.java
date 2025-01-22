package com.proyecto.proyecto.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Category;

@Service
public interface CategoryService {
    
    List<Category> findAllCategory();

    Category saveCategory(Category category);

    boolean deleteCategory(Long id_category);

    Optional<Category> findCategoryById(Long id_category);
}
