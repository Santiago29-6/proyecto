package com.proyecto.proyecto.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.constant.Message;
import com.proyecto.proyecto.exception.NotFoundException;
import com.proyecto.proyecto.model.Category;
import com.proyecto.proyecto.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl (CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        if(category.getId() != null){
            findCategoryById(category.getId());
        }
        return categoryRepository.save(category);
    }

    @Override
    public boolean deleteCategory(Long id_category) {
        if (findCategoryById(id_category).isPresent()) {
            categoryRepository.deleteById(id_category);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Category> findCategoryById(Long id_category) {
        Optional<Category> category = categoryRepository.findById(id_category);
        if(category.isEmpty()) {
            throw new NotFoundException(String.format(Message.CATEGORY_NOT_FOUND, id_category));
        }
        return category;
    }
}
