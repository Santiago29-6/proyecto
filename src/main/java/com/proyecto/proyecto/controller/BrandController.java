package com.proyecto.proyecto.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.Brand;
import com.proyecto.proyecto.service.brand.BrandServiceImpl;

@RestController
@RequestMapping("/api")
public class BrandController {

    private final BrandServiceImpl brandServiceImpl;

    public BrandController (BrandServiceImpl brandServiceImpl){
        this.brandServiceImpl = brandServiceImpl;
    }

    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> getAllBrands(){
        return ResponseEntity.ok(brandServiceImpl.findAll());
    }

    @PostMapping("/brand/save")
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand) {
        Brand brandCreated = brandServiceImpl.saveBrand(brand);
        try {
            return ResponseEntity.created(new URI("/api/brand/" + brandCreated.getId())).body(brandCreated);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/brand/delete/{id}")
    public ResponseEntity<Boolean> deleteBrand(@PathVariable("id") Long id_brand){
        brandServiceImpl.deleteBrand(id_brand);
        return ResponseEntity.ok(!(brandServiceImpl.findBrandById(id_brand).isPresent()));
    }


}
