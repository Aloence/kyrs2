package com.example.shop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username,password;
    private boolean role;
    
    public UserEntity(){
    }
    public Long getId(){
        return id;
    }
    public boolean getRole(){
        return role;
    }
    public String getUsername(){
        return username;
    }
    public void setMail(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
