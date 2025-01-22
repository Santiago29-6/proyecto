package com.proyecto.proyecto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.proyecto.model.Product;
import com.proyecto.proyecto.service.product.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    public ProductController (ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productServiceImpl.findAllProducts());
    }

    @PostMapping("/product/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product productSave = productServiceImpl.saveProduct(product);
        HttpStatus status = (product.getId() ==  null) ? HttpStatus.CREATED : HttpStatus.OK;
        return ResponseEntity.status(status).body(productSave);
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") Long id_product){
        return ResponseEntity.ok(productServiceImpl.deleteProduct(id_product));
    }

}
