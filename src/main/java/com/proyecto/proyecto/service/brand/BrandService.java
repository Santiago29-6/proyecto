package com.proyecto.proyecto.service.brand;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Brand;

@Service
public interface BrandService {

    List<Brand> findAll();

    Optional<Brand> findBrandById(Long id);

    Brand saveBrand(Brand brand);

    void deleteBrand(Long id);

}
