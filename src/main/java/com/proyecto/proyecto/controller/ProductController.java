package com.proyecto.proyecto.controller;

import java.net.URI;
import java.net.URISyntaxException;
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
        try {
            return ResponseEntity.created(new URI("/api/product/" + productSave.getId())).body(productSave);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/product/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") Long id_product){
        productServiceImpl.deleteProduct(id_product);
        return ResponseEntity.ok(!(productServiceImpl.findProductById(id_product).isPresent()));
    }

}
