package com.proyecto.proyecto.service.category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Category;
import com.proyecto.proyecto.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        category.setRegistrationDate(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id_category) {
        categoryRepository.deleteById(id_category);
    }

    @Override
    public Optional<Category> findCategoryById(Long id_category) {
        return categoryRepository.findById(id_category);
    }
}
