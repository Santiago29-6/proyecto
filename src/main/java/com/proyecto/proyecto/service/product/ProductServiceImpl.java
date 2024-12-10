package com.proyecto.proyecto.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Product;
import com.proyecto.proyecto.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
}
