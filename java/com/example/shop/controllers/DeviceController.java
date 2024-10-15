package com.example.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.shop.entities.DeviceEntity;
import com.example.shop.exceptions.InternalException;
import com.example.shop.services.DeviceService;

@CrossOrigin
@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editDevice(@RequestBody DeviceEntity device,
                                     @RequestParam Long id){
        try{
            return ResponseEntity.ok(deviceService.editDevice(device,id));
        }catch(InternalException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createDevice(@RequestBody DeviceEntity device){
        try{
            return ResponseEntity.ok(deviceService.createDevice(device));
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity getOneDevice(@PathVariable Long id){
        try{
            return ResponseEntity.ok(deviceService.getOneDevice(id));
        }catch(InternalException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteDevice(@PathVariable Long id){
        try{
            return ResponseEntity.ok(deviceService.deleteDevice(id));
        }catch(InternalException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    
    @GetMapping
    public ResponseEntity getFilteredDevices(@RequestParam(required = false) Long brandId,
                                             @RequestParam String search){
        try{
            return ResponseEntity.ok(deviceService.getFilteredDevices(brandId,search));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
