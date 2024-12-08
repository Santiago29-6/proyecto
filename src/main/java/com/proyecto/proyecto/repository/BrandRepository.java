package com.proyecto.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.proyecto.model.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

}
