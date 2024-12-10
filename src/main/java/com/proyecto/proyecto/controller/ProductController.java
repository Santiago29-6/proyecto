package com.proyecto.proyecto.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.proyecto.model.Product;
import com.proyecto.proyecto.service.product.ProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @PostMapping("save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product productSave = productService.saveProduct(product);
        try {
            return ResponseEntity.created(new URI("/product/" + productSave.getId())).body(productSave);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") Long id_product){
        productService.deleteProduct(id_product);
        return ResponseEntity.ok(!(productService.findProductById(id_product).isPresent()));
    }

}
