package com.example.shop.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.shop.entities.DeviceEntity;
public interface DeviceRepo extends CrudRepository<DeviceEntity,Long>{
}
