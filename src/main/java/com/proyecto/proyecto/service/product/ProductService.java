package com.proyecto.proyecto.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Product;

@Service
public interface ProductService {

    List<Product> findAllProducts();

    Optional<Product> findProductById(Long id);

    boolean deleteProduct(Long id);

    Product saveProduct(Product product);
    
}
