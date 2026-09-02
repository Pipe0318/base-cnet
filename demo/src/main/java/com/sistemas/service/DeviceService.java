package com.sistemas.service;

import java.util.List;

import com.sistemas.model.Device;

public interface DeviceService {
    public List<Device> listDevices();
    void registerDevice(Device device);
    Device getDeviceById(Integer id);
}
