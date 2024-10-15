package com.example.shop.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.entities.DeviceEntity;
import com.example.shop.exceptions.InternalException;
import com.example.shop.repository.DeviceRepo;


@Service
public class DeviceService {
    @Autowired
    private DeviceRepo deviceRepo;

    public DeviceEntity editDevice(DeviceEntity device,Long id) throws InternalException{
        DeviceEntity tempDevice = deviceRepo.findById(id).get();
        if(device == null){
            throw new InternalException("Такое устройство не найдено");
        }
        
        tempDevice.setBrand(device.getBrand());
        tempDevice.setCharacteristics(device.getCharacteristics());
        tempDevice.setImg(device.getImg());
        tempDevice.setName(device.getName());
        tempDevice.setPrice(device.getPrice());

        return deviceRepo.save(tempDevice);
    }
    
    public DeviceEntity createDevice(DeviceEntity device){
        return  deviceRepo.save(device);
    }

    public Iterable<DeviceEntity> getFilteredDevices(Long brandId,String search) {
        Iterable<DeviceEntity> devices= deviceRepo.findAll();
        List<DeviceEntity> devs= new ArrayList<>();

        if(brandId==null){
            for (DeviceEntity device:devices){          
                if(device.getName().contains(search) ){
                    devs.add(device);
                }
            }
            return devs;
        }
 
        for (DeviceEntity device:devices){
            if(device.getBrand().getId() == brandId){
                 if(device.getName().contains(search) ){
                    devs.add(device);
                }
            }
        }
        return devs;
    }

    public DeviceEntity getOneDevice(Long id) throws InternalException{
        DeviceEntity device = deviceRepo.findById(id).get();
        if(device == null){
            throw new InternalException("Такое устройство не найдено");
        }
        return device;
    }

    public boolean deleteDevice(Long id) throws InternalException{
        DeviceEntity device = deviceRepo.findById(id).get();
        if(device == null){
            throw new InternalException("Такое устройство не найдено");
        }
        deviceRepo.deleteById(id);
        return true;
    }
}
