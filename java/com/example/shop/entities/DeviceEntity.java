package com.example.shop.entities;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name,img;
    private double price;

    @OneToMany(cascade = CascadeType.ALL)
    private List<DeviceInfoEntity> characteristics= new ArrayList<>();

    @ManyToOne
    @JoinColumn(name ="brand_id")
    private BrandEntity brand;

    public DeviceEntity(){
    }
    public List<DeviceInfoEntity> getCharacteristics(){
        return characteristics;
    }
    public void setCharacteristics(List<DeviceInfoEntity> characteristics){
        this.characteristics= characteristics;
    }
    public BrandEntity getBrand(){
        return brand;
    }
    public void setBrand(BrandEntity brand){
        this.brand = brand;
    }
    public Long getId(){
        return id;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getImg(){
        return img;
    }
    public void setImg(String img){
        this.img = img;
    }
}
