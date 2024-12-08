package com.proyecto.proyecto.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.proyecto.proyecto.service.brand.BrandService;

@RestController
@RequestMapping("/brand/")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public ResponseEntity<List<Brand>> getAllBrands(){
        return ResponseEntity.ok(brandService.findAll());
    }

    @PostMapping("save")
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand) {
        Brand brandCreated = brandService.saveBrand(brand);
        try {
            return ResponseEntity.created(new URI("/brand/" + brandCreated.getId())).body(brandCreated);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteBrand(@PathVariable("id") Long id_brand){
        brandService.deleteBrand(id_brand);
        return ResponseEntity.ok(!(brandService.findBrandById(id_brand).isPresent()));
    }


}
