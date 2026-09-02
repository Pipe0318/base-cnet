package com.sistemas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sistemas.model.Device;
import com.sistemas.repository.DeviceRepository;

@Service
@Primary
public class DeviceServiceImpl implements DeviceService{
    private final DeviceRepository deviceRepository;


    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public List<Device> listDevices(){
        System.out.println("Soy el bean de inyeccion por constructor");
        return deviceRepository.getAll();
    }

    @Override 
    public void registerDevice(Device device){
        deviceRepository.registerDevice(device);
    }

    @Override
    public Device getDeviceById(Integer id){
        return deviceRepository.getDeviceById(id);
    }
   
    
}
