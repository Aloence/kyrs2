package com.example.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.entities.UserEntity;
import com.example.shop.exceptions.InternalException;
import com.example.shop.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws InternalException{
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new InternalException("Пользователь с таким именем существует");
        }
        return userRepo.save(user);
    }

    public UserEntity login(UserEntity user) throws InternalException{
        UserEntity tempUser =  userRepo.findByUsername(user.getUsername());
        if(tempUser == null){
            throw new InternalException("Пользователь с таким именем не найден");
        }
        if( !tempUser.getPassword().equals(user.getPassword())){
            throw new InternalException("Неверный пароль");
        }
        return tempUser;
    }    
}
