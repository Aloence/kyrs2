package com.example.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.entities.BrandEntity;

import com.example.shop.repository.BrandRepo;

@Service
public class BrandService {
    @Autowired
    private BrandRepo brandRepo;

    public  BrandEntity createBrand(BrandEntity brand){
        return brandRepo.save(brand);
    }
    
    public Iterable<BrandEntity> getAllBrands() {
        return brandRepo.findAll();
    }
}
