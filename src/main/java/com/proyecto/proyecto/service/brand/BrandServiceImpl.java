package com.proyecto.proyecto.service.brand;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Brand;
import com.proyecto.proyecto.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findBrandById(Long id){
        return brandRepository.findById(id);
    }

    @Override
    public Brand saveBrand(Brand brand){
        return brandRepository.save(brand);
    }

    @Override
    public void deleteBrand(Long id_brand){
        brandRepository.deleteById(id_brand);
    }

}
