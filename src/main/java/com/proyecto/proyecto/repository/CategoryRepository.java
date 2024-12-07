package com.proyecto.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
