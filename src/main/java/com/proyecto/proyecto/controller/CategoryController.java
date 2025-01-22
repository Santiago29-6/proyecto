package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.Category;
import com.proyecto.proyecto.service.category.CategoryServiceImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryServiceImpl.findAllCategory());
    }

    @PostMapping("/category/save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category categorySave = categoryServiceImpl.saveCategory(category);
        HttpStatus status = (category.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;
        return ResponseEntity.status(status).body(categorySave);
    }

    @DeleteMapping("/category/delete/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") Long id_category) {
        return ResponseEntity.ok(categoryServiceImpl.deleteCategory(id_category));
    }

}
