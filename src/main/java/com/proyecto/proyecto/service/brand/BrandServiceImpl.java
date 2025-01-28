package com.proyecto.proyecto.service.brand;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.constant.Message;
import com.proyecto.proyecto.exception.NotFoundException;
import com.proyecto.proyecto.model.Brand;
import com.proyecto.proyecto.repository.BrandRepository;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findBrandById(Long id_brand) {
        Optional<Brand> brand = brandRepository.findById(id_brand);
        if (brand.isEmpty()) {
            throw new NotFoundException(String.format(Message.BRAND_NOT_FOUND, id_brand));
        }
        return brand;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        if(brand.getId() != null) {
            findBrandById(brand.getId());
        }
        return brandRepository.save(brand);
    }

    @Override
    public boolean deleteBrand(Long id_brand) {
        if (findBrandById(id_brand).isPresent()) {
            brandRepository.deleteById(id_brand);
            return true;
        }
        return false;
    }

}
