package com.proyecto.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
