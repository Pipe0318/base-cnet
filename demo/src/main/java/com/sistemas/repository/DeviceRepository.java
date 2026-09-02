package com.sistemas.repository;

import java.util.List;

import com.sistemas.model.Device;

public interface DeviceRepository {

    List<Device> getAll();
    void registerDevice(Device device); 
    Device getDeviceById(Integer id);
    
}
