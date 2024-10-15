package com.example.shop.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.shop.entities.BrandEntity;
public interface BrandRepo extends CrudRepository<BrandEntity,Long>{
}
