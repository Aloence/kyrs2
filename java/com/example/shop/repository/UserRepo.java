package com.example.shop.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.shop.entities.UserEntity;
public interface UserRepo extends CrudRepository<UserEntity,Long>{
    UserEntity findByUsername(String username);
}
