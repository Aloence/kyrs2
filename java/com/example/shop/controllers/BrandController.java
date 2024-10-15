package com.example.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shop.entities.BrandEntity;
import com.example.shop.services.BrandService;

@CrossOrigin
@RequestMapping("/brands")
@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity createBrand(@RequestBody BrandEntity brand) {
        try {
            return ResponseEntity.ok(brandService.createBrand(brand));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getAllBrands() {
        try {
            return ResponseEntity.ok(brandService.getAllBrands());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
