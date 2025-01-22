package com.proyecto.proyecto.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.exception.NotFoundException;
import com.proyecto.proyecto.model.Product;
import com.proyecto.proyecto.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id_product){
        Optional<Product> product = productRepository.findById(id_product);
        if (product.isEmpty()) {
            throw new NotFoundException("No se ha encontrado un producto con ese id: " + id_product);
        }
        return product;
    }

    @Override
    public boolean deleteProduct(Long id) {
        if (findProductById(id).isPresent()) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Product saveProduct(Product product){
        if (product.getId() != null) {
            findProductById(product.getId());
        }
        return productRepository.save(product);
    }
}
