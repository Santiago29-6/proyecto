package com.proyecto.proyecto.controller;

import com.proyecto.proyecto.model.Category;
import com.proyecto.proyecto.service.category.CategoryServiceImpl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category/")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.findAllCategory());
    }

    @PostMapping("save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        try {
            Category categorySave = categoryService.saveCategory(category);
            return ResponseEntity.created(new URI("category/"+categorySave.getId())).body(categorySave);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") Long id_category){
        categoryService.deleteCategory(id_category);
        return ResponseEntity.ok(!(categoryService.findCategoryById(id_category)).isPresent());
    }

}
