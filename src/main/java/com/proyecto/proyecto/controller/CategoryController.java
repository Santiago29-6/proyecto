package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.Category;
import com.proyecto.proyecto.service.category.CategoryServiceImpl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    public CategoryController (CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryServiceImpl.findAllCategory());
    }

    @PostMapping("/category/save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        try {
            Category categorySave = categoryServiceImpl.saveCategory(category);
            return ResponseEntity.created(new URI("/api/category/"+categorySave.getId())).body(categorySave);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") Long id_category){
        categoryServiceImpl.deleteCategory(id_category);
        return ResponseEntity.ok(!(categoryServiceImpl.findCategoryById(id_category)).isPresent());
    }

}
